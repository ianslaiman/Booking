package TicketFolder;

public abstract class Ticket {
    private int TicketIdentifier;
    private int TicketPrice;
    private String TicketBrand;
    private String TicketDate;
    private String TicketType;
    private String TicketDestination;
    private String TicketOrigin;
    private String TicketDocumentRequired;
    // Stored as text: real card numbers (13-19 digits) do not fit in an int.
    private String CreditCard;

    /** Human-readable kind of ticket, e.g. "Transport" or "Hotel". */
    protected abstract String getKind();

    public int getTicketIdentifier() {
        return TicketIdentifier;
    }
    public int getTicketPrice() {
        return TicketPrice;
    }
    public String getTicketBrand() {
        return TicketBrand;
    }
    public String getTicketDate() {
        return TicketDate;
    }
    public String getTicketType() {
        return TicketType;
    }
    public String getTicketDestination() {
        return TicketDestination;
    }
    public String getTicketOrigin() {
        return TicketOrigin;
    }
    public String getTicketDocumentRequired() {
        return TicketDocumentRequired;
    }
    public String getCreditCard(){
        return CreditCard;
    }
    public void setTicketIdentifier(int TicketIdentifier) {
        this.TicketIdentifier = TicketIdentifier;
    }
    public void setTicketPrice(int TicketPrice) {
        this.TicketPrice = TicketPrice;
    }
    public void setTicketBrand(String TicketBrand) {
        this.TicketBrand = TicketBrand;
    }
    public void setTicketDate(String TicketDate) {
        this.TicketDate = TicketDate;
    }
    public void setTicketType(String TicketType) {
        this.TicketType = TicketType;
    }
    public void setTicketDestination(String TicketDestination) {
        this.TicketDestination = TicketDestination;
    }
    public void setTicketOrigin(String TicketOrigin) {
        this.TicketOrigin = TicketOrigin;
    }
    public void setTicketDocumentRequired(String TicketDocumentRequired) {
        this.TicketDocumentRequired = TicketDocumentRequired;
    }
    public void setCreditCard(String CreditCard) {
        this.CreditCard = CreditCard;
    }

    /** Card number with everything except the last 4 digits hidden. */
    public String getMaskedCreditCard() {
        if (CreditCard == null || CreditCard.length() < 4) {
            return null;
        }
        return "**** " + CreditCard.substring(CreditCard.length() - 4);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKind()).append(" ticket #").append(TicketIdentifier);
        appendLine(sb, "Brand", TicketBrand);
        appendLine(sb, "Date", TicketDate);
        appendLine(sb, "From", TicketOrigin);
        appendLine(sb, "Destination", TicketDestination);
        appendLine(sb, "Document", TicketDocumentRequired);
        appendLine(sb, "Card", getMaskedCreditCard());
        appendLine(sb, "Price", TicketPrice + "€");
        return sb.toString();
    }

    private static void appendLine(StringBuilder sb, String label, String value) {
        if (value != null && !value.isEmpty()) {
            sb.append(String.format("%n  %-12s %s", label + ":", value));
        }
    }
}
