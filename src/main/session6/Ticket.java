package src.main.session6;


class Ticket {
    private String codeTicket;
    private String base = "TK";
    private boolean active;
    static int nextID = 0;

    public Ticket() {
        this.codeTicket = base.concat(Integer.toString(nextID));
        this.active = true;
        nextID++;
    }

    public String getCode(){
        return this.codeTicket;
    }

    public boolean getActive(){
        return this.active;
    }

    public void setActive(boolean status){
        this.active = status;
    }
}

