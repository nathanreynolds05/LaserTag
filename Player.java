public class Player {
    private int id;
    private String codename;

    Player(int id, String codename){
        this.id = id;
        this.codename = codename;
    }

    public int getId(){ return id; }
    public String getCodename(){ return codename; }

    public void setId(int id){ this.id = id; }
    public void setCodename(String codename){ this.codename = codename; }

    public String toString(){
        return "Player: " + id + " " + codename;
    }

    public boolean equals(Object o){
        if(o instanceof Player){
            Player p = (Player) o;
            return (this.id == p.id && this.codename.equals(p.codename));
        }
        return false;
    }
}
