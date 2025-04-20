import Code.Base64Implementation;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class InterfaceController {

    @FXML
    private TextArea inputText;

    @FXML
    private TextArea outputText;

    @FXML
    private TextArea authenticatorText;

    @FXML
    private TextArea functionText;

    // Encrypt Button Handler
    public void encryptText() {
        String input = inputText.getText();
        if (input.isEmpty()) {
            outputText.setText("Please enter text to encrypt");
            return;
        }

        // Use both implementations
        String customEncoded = Base64Implementation.customEncode(input.getBytes());
        String javaEncoded = java.util.Base64.getEncoder().encodeToString(input.getBytes());

        // Set output to custom implementation
        outputText.setText(customEncoded);

        // Show comparison in authenticator
        String authMessage = "Custom Base64 Encoding:\n" + customEncoded +
                "\n\nJava Built-in Base64 Encoding:\n" + javaEncoded +
                "\n\nResults match: " + customEncoded.equals(javaEncoded);
        authenticatorText.setText(authMessage);

        // Set function explanation
        functionText.setText("Base64 Encoding Function:\n\n" +
                "- Converts input string to Base64 encoded format\n" +
                "- Uses 64-character alphabet (A-Z, a-z, 0-9, +, /)\n" +
                "- Padding with '=' if needed");
    }
 // Decrypt Button Handler
    public void decryptText() {
        String input = inputText.getText();
        if (input.isEmpty()) {
            outputText.setText("Please enter text to decrypt");
            return;
        }

        try {
            // Use both implementations
            String customDecoded = new String(Base64Implementation.customDecode(input));
            String javaDecoded = new String(java.util.Base64.getDecoder().decode(input));

            // Set output to custom implementation
            outputText.setText(customDecoded);

            // Show comparison in authenticator
            String authMessage = "Custom Base64 Decoding:\n" + customDecoded +
                    "\n\nJava Built-in Base64 Decoding:\n" + javaDecoded +
                    "\n\nResults match: " + customDecoded.equals(javaDecoded);
            authenticatorText.setText(authMessage);

            // Set function explanation
            functionText.setText("Base64 Decoding Function:\n\n" +
                    "- Converts Base64 encoded string back to original format\n" +
                    "- Handles padding characters ('=')\n" +
                    "- Validates input format");
        } catch (IllegalArgumentException e) {
        outputText.setText("Invalid Base64 input");
            authenticatorText.setText("Error in decoding:\n" + e.getMessage());
        functionText.setText("Invalid Base64 input detected");
        }
                }

// Copy Result Button Handler
public void copyResult() {
    String result = outputText.getText();
    if (result.isEmpty()) {
        authenticatorText.setText("No result to copy!");
        return;
    }

    Clipboard clipboard = Clipboard.getSystemClipboard();
    ClipboardContent content = new ClipboardContent();
    content.putString(result);
    clipboard.setContent(content);

    // Update Authenticator message
    authenticatorText.setText("Result copied to clipboard!\n\n" +
            "Content copied:\n" + result);
}
}
