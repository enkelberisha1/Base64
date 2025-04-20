# Custom Base64 Encoder/Decoder in JavaFX

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.java.com/en/)
[![JavaFX](https://img.shields.io/badge/JavaFX-17+-blueviolet.svg)](https://openjfx.io/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This project, developed by second-year Computer Engineering students at FIEK, implements a custom Base64 encoder and decoder in Java, without relying on Java's built-in `Base64.getEncoder()` and `Base64.getDecoder()` methods. The application also features a user-friendly graphical interface (GUI) built with JavaFX.

**Developed by:**

* Enkel Berisha ([@EnkelBerisha](https://github.com/enkelberisha1))
* Engji Osmani ([@EngjiOsmani](https://github.com/engjiosmani))
* Enes Spahiu ([@EnesSpahiu](https://github.com/enesiktm1))
* Enis Morina ([@EnisMorina](https://github.com/enismorina1))

## Clone command:
```bash
git clone https://github.com/enkelberisha1/Base64.git
```
## Project Description

This Java program provides a hands-on implementation of Base64 encoding and decoding. It converts binary data (`byte[]`) to a Base64 encoded string and vice-versa, adhering to the standard of dividing bits into 6-bit blocks and adding `=` padding when necessary.


The included JavaFX GUI empowers users to:

* **Encode text to Base64:** Input text and see its Base64 representation.
* **Decode text from Base64:** Paste a Base64 string and retrieve the original text.
* **Compare results:** Instantly compare the output of the custom implementation with Java's standard Base64 encoder/decoder.
* **Copy to clipboard:** Easily copy the encoded or decoded result with a single click.

## Key Functionalities

### `Base64Implementation.java`

* **`customEncode(byte[] data)`**: Manually converts byte array data into a Base64 encoded string.
* **`customDecode(String encoded)`**: Recovers the original byte data from a Base64 encoded string.

**Implementation Details:**

* Bit manipulation (`<<`, `>>`, `&`, `|`) for precise bit processing.
* Robust input handling, including checks for `null` inputs.
* Automatic padding with the `=` character as per the Base64 standard.
* Efficient grouping of bits and conversion of 6-bit chunks into Base64 characters.

### `Base64App.java`

* Initializes and launches the JavaFX GUI application.
* Loads the user interface defined in `Interface.fxml`.
* Manages the primary `Stage` and `Scene` for displaying the application window.

### `InterfaceController.java`

* Handles all GUI events triggered by user interactions (encoding, decoding, copying).
* Orchestrates the comparison between the custom and Java's built-in Base64 implementations.
* Provides informative explanations of the functionalities within the GUI.

### `Interface.fxml`

* Defines the structure and layout of the graphical user interface using TextAreas for input and output, and Buttons for actions.

* Presents a clean and intuitive visual interface for ease of use.

## How to Run the Program

1.  **Open the project:** Import the project into your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
2.  **Ensure dependencies:** Verify that you have Java Development Kit (JDK) 17 or higher installed and JavaFX configured correctly within your IDE.
3.  **Run `Base64App.java`:** Execute the `main` method in the `Base64App.java` file. This will launch the graphical user interface.

## Using the GUI

Once the application is running, you will see the main window with the following options:

1.  **Input Field:** Enter the text you want to encode or the Base64 string you want to decode in the top text area.
2.  **Encrypt Button:** Click this button to encode the text in the input field using the custom Base64 implementation. The result will be displayed in the "Custom Encoded" text area. The standard Java encoding will appear in the "Java Encoded" text area for comparison.
3.  **Decrypt Button:** Click this button to decode the Base64 string in the input field using the custom Base64 implementation. The original text will be shown in the "Custom Decoded" text area. The standard Java decoding will appear in the "Java Decoded" text area for comparison.
4.  **Comparison Areas:** These text areas display the results from both the custom implementation and Java's built-in functions, allowing for direct comparison.
5.  **Copy Button:** Click the "Copy" button next to the desired result (custom encoded, Java encoded, custom decoded, Java decoded) to copy the text to your system's clipboard.

## Usage Examples

### Encoding Example

**Input:** `"Man"`

**Output:** `"TWFu"`

### Decoding Example

**Input Base64:** `"TQ=="`

1.  Remove padding: `"TQ"`
2.  `T` -> index = 19 -> `010011`
3.  `Q` -> index = 16 -> `010000`
4.  Combine bits: `010011010000` (12 bits)
5.  Take the first 8 bits: `01001101` = 77 -> `'M'`

## Screenshots

### Main interface after launching the application

![main](https://github.com/user-attachments/assets/0ed893d6-ff6a-4abe-8d5c-a130deeacb46)


### Encoding process of a text to Base64
![Encoding](https://github.com/user-attachments/assets/1de3bc30-e8be-4e68-93cd-b6e71d1ecff0)


### Decoding process of a Base64 string

![Decoding](https://github.com/user-attachments/assets/cc0d4a94-f0f1-4a28-aed5-7a5fc5cbdbf0)


## Conclusion
