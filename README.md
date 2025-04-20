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
