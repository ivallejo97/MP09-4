import javax.crypto.SecretKey;
import java.util.Arrays;

public class EJ5 {

    public static void main(String[] args) {
        String message = "Hola mundo";
        int keySize = 128;
        SecretKey secretKey = UtilitatsXifrar.keygenKeyGeneration(keySize);
        System.out.println(secretKey.getAlgorithm());
        System.out.println(secretKey.getFormat());
        System.out.println(Arrays.toString(secretKey.getEncoded()));

        byte[] encryptedData = UtilitatsXifrar.encryptData(message.getBytes(),secretKey);

        byte[] decryptedData;
        try {
            decryptedData = UtilitatsXifrar.decryptData(encryptedData, secretKey);
            System.out.println("Mensaje descifrado (Clave Aleatoria): " + new String(decryptedData));
        } catch (Exception exception) {
            System.out.println("Error descifrando los datos: " + exception);
        }
    }

}