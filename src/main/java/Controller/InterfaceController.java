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