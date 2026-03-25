import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HasheadorString{
    static String sha1(String entrada){
        try{
            MessageDigest algoritimo = MessageDigest.getInstance("SHA-1");

            byte[] bytesE = entrada.getBytes("UTF-8");
            byte[] bytesH = algoritimo.digest(bytesE);

            StringBuilder hexadecimal = new StringBuilder();

            for (byte b : bytesH){
                hexadecimal.append(String.format("%02x", 0xFF & b));
            }
            return hexadecimal.toString();
        } catch(NoSuchAlgorithmException e){
            throw new RuntimeException("Algoritimo SHA-1 não encontrado: " + e.getMessage());
        } catch(Exception e){
            throw new RuntimeException("Erro ao gerar hash: " + e.getMessage());
        }
    }
}