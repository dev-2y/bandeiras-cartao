import java.util.HashMap;
import java.util.Map;

public class CardValidator {

    private static final Map<String, String[]> CARD_BRANDS = new HashMap<>();

    static {
        // Prefixos e comprimentos baseados no site 4devs
        CARD_BRANDS.put("Visa", new String[]{"4", "13,16"});
        CARD_BRANDS.put("MasterCard", new String[]{"51,52,53,54,55,2221-2720", "16"});
        CARD_BRANDS.put("American Express", new String[]{"34,37", "15"});
        CARD_BRANDS.put("Diners Club", new String[]{"300-305,36,38", "14"});
        CARD_BRANDS.put("Discover", new String[]{"6011,622126-622925,644-649,65", "16"});
        CARD_BRANDS.put("JCB", new String[]{"3528-3589", "16"});
        CARD_BRANDS.put("Elo", new String[]{"401178,401179,431274,438935,451416,457393,457631,457632,504175,627780,636297,636368", "16"});
        CARD_BRANDS.put("Hipercard", new String[]{"606282,384100-384199", "16,19"});
        CARD_BRANDS.put("Aura", new String[]{"50", "16"});
        CARD_BRANDS.put("EnRoute", new String[]{"2014,2149", "15"}); // Adicionado EnRoute
        CARD_BRANDS.put("Voyager", new String[]{"8699", "15"});       // Adicionado Voyager
    }

    public static String validateCardBrand(String cardNumber) {
        for (Map.Entry<String, String[]> entry : CARD_BRANDS.entrySet()) {
            String brand = entry.getKey();
            String[] rules = entry.getValue();
            String[] prefixes = rules[0].split(",");
            String[] lengths = rules[1].split(",");

            if (matchesPrefix(cardNumber, prefixes) && matchesLength(cardNumber, lengths)) {
                return brand;
            }
        }
        return "Unknown";
    }

    private static boolean matchesPrefix(String cardNumber, String[] prefixes) {
        for (String prefix : prefixes) {
            if (prefix.contains("-")) {
                String[] range = prefix.split("-");
                int start = Integer.parseInt(range[0]);
                int end = Integer.parseInt(range[1]);
                int cardPrefix = Integer.parseInt(cardNumber.substring(0, range[0].length()));
                if (cardPrefix >= start && cardPrefix <= end) {
                    return true;
                }
            } else if (cardNumber.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    private static boolean matchesLength(String cardNumber, String[] lengths) {
        for (String length : lengths) {
            if (cardNumber.length() == Integer.parseInt(length)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Teste da função
        String cardNumber = "6062826458903127";
        String brand = validateCardBrand(cardNumber);
        System.out.println("Bandeira: " + brand);
    }
}