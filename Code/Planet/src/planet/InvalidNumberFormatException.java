/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package planet;

/**
 *
 * @author Muhammad Eman Aftab
 * 
 * InvalidNumberFormatException extending exception class.
 */
class InvalidNumberFormatException extends Exception {
    /**
     * 
     * @param message which is used to show message which type of error it is and then using super to call the constructor of parent
     */
    public InvalidNumberFormatException(String message) {
        super(message);
    }
}
