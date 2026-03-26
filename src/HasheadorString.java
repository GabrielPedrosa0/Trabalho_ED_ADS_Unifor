import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HasheadorString {
    public static String sha1(String entrada) {
        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA1");
            byte[] result = mDigest.digest(entrada.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Algoritimo SHA-1 não encontrado: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar hash: " + e.getMessage());
        }
    }
}