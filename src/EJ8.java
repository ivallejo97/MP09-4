import javax.crypto.SecretKey;

public class EJ8 {

    public static void main(String[] args) {
        String message = "Hola mundo";
        int keySize = 128;
        SecretKey secretKeyPassword = UtilitatsXifrar.passwordKeyGeneration("usuario",keySize);
        SecretKey secretKeyPassword2 = UtilitatsXifrar.passwordKeyGeneration("123456",keySize);

        byte[] encryptedPasswordData = UtilitatsXifrar.encryptData(message.getBytes(), secretKeyPassword);

        byte[] decryptedDataPassword;
        try {
            decryptedDataPassword = UtilitatsXifrar.decryptData(encryptedPasswordData,secretKeyPassword2);
            System.out.println("Mensaje descifrado (Clave de contraseña): " + new String(decryptedDataPassword));

        } catch (Exception exception){
            System.out.println("Error descifrando los datos: " + exception);
        }
    }
}
