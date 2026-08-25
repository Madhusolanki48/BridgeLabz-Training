package com.example.fundoonotes.dto;

public class NoteImportResult {
    private int readCount;
    private int writeCount;
    private int skipCount;

    public NoteImportResult(int readCount, int writeCount, int skipCount) {
        this.readCount = readCount;
        this.writeCount = writeCount;
        this.skipCount = skipCount;
    }

    public int getReadCount() {
        return readCount;
    }

    public int getWriteCount() {
        return writeCount;
    }

    public int getSkipCount() {
        return skipCount;
    }
}
