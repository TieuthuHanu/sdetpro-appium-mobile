package test_data;

public class FormsInputField {

    private String inputfield;

    public FormsInputField(String inputfield) {
        this.inputfield = inputfield;
    }

    public String getInputField() {
        return inputfield;
    }

    @Override
    public String toString() {
        return "FormsInputField{" +
                "inputfield='" + inputfield + '\'' +
                '}';
    }
}
