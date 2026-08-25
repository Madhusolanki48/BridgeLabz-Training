package com.example.fundoonotes.service;

import com.example.fundoonotes.dto.NoteImportResult;
import com.example.fundoonotes.entity.Note;
import com.example.fundoonotes.entity.User;
import com.example.fundoonotes.exception.InvalidCredentialsException;
import com.example.fundoonotes.repository.NoteRepository;
import com.example.fundoonotes.repository.UserRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteExcelBatchService {
    private static final String[] HEADERS = {
            "title", "description", "color", "typeOfNote", "imageUrl", "linkUrl"
    };

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteExcelBatchService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    // UC-11: Import notes from an Excel sheet and report batch-style counts
    public NoteImportResult importNotes(MultipartFile file, String email) throws IOException {
        User user = getUser(email);
        int readCount = 0;
        int skipCount = 0;
        List<Note> notes = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            for (Row row : workbook.getSheetAt(0)) {
                if (row.getRowNum() == 0 || isEmpty(row)) {
                    continue;
                }

                readCount++;
                String title = getCellValue(row, 0);
                String description = getCellValue(row, 1);

                if (title.isBlank() || description.isBlank()) {
                    skipCount++;
                    continue;
                }

                notes.add(buildNote(row, user, title, description));
            }
        }

        noteRepository.saveAll(notes);
        return new NoteImportResult(readCount, notes.size(), skipCount);
    }

    // UC-11: Export the logged-in user's active notes as a real .xlsx file
    public byte[] exportNotes(String email) throws IOException {
        List<Note> notes = noteRepository.findByUser_EmailAndTrashedFalse(email);

        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            var sheet = workbook.createSheet("notes");
            writeHeader(sheet.createRow(0));

            for (int i = 0; i < notes.size(); i++) {
                writeNote(sheet.createRow(i + 1), notes.get(i));
            }

            for (int i = 0; i < HEADERS.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }

    private User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new InvalidCredentialsException("User not found!"));
    }

    private Note buildNote(Row row, User user, String title, String description) {
        Note note = new Note();
        note.setUser(user);
        note.setTitle(title);
        note.setDescription(description);
        note.setColor(getCellValue(row, 2));
        note.setTypeOfNote(getCellValue(row, 3));
        note.setImageUrl(getCellValue(row, 4));
        note.setLinkUrl(getCellValue(row, 5));
        return note;
    }

    private void writeHeader(Row row) {
        for (int i = 0; i < HEADERS.length; i++) {
            row.createCell(i).setCellValue(HEADERS[i]);
        }
    }

    private void writeNote(Row row, Note note) {
        row.createCell(0).setCellValue(note.getTitle());
        row.createCell(1).setCellValue(note.getDescription());
        row.createCell(2).setCellValue(nullToBlank(note.getColor()));
        row.createCell(3).setCellValue(nullToBlank(note.getTypeOfNote()));
        row.createCell(4).setCellValue(nullToBlank(note.getImageUrl()));
        row.createCell(5).setCellValue(nullToBlank(note.getLinkUrl()));
    }

    private String getCellValue(Row row, int index) {
        Cell cell = row.getCell(index, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
        return cell == null ? "" : cell.toString().trim();
    }

    private boolean isEmpty(Row row) {
        for (int i = 0; i < HEADERS.length; i++) {
            if (!getCellValue(row, i).isBlank()) {
                return false;
            }
        }
        return true;
    }

    private String nullToBlank(String value) {
        return value == null ? "" : value;
    }
}
