package lambda_expression;

//functional interface
interface LightAction {
	void activate();
}

public class SmartHomeLightingAutomation {
	public static void main(String[] args) {

		//motion detected: turn on bright light
		LightAction motionTrigger = () -> System.out.println("Bright lights ON");

		//night time: dim lights
		LightAction nightTrigger = () -> System.out.println("Dim lights ON");

		//voice command: colored lights
		LightAction voiceTrigger = () -> System.out.println("Colored lights ON");

		motionTrigger.activate();
		nightTrigger.activate();
		voiceTrigger.activate();
	}
}
