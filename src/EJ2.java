import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EJ2 {

    public static void main(String[] args) throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {

        Path path = Paths.get("C:\\Users\\ivall\\Downloads\\textamagat.crypt");
        byte[] textenbytes = Files.readAllBytes(path);

        File f = new File("C:\\Users\\ivall\\Downloads\\clausA4.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while(line != null ) {
            SecretKey secretKey = UtilitatsXifrar.passwordKeyGeneration(line,128);
            byte[] result = UtilitatsXifrar.decryptData(textenbytes,secretKey);
            String string = new String(result,0,result.length);
            System.out.println("Mensaje : " + string);
            line = br.readLine();
        }

    }
}
