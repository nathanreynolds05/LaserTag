public class Player {
    private int id;
    private String first_name;
    private String last_name;
    private String codename;

    Player(int id, String first_name, String last_name, String codename){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.codename = codename;
    }

    public int getId(){ return id; }
    public String getFirstName(){ return first_name; }
    public String getLastName(){ return last_name; }
    public String getCodename(){ return codename; }

    public void setId(int id){ this.id = id; }
    public void setFirstName(String first_name){ this.first_name = first_name; }
    public void setLastName(String last_name){ this.last_name = last_name; }
    public void setCodename(String codename){ this.codename = codename; }

    public String toString(){
        return "Player: " + id + " " + first_name + " " + last_name + " " + codename;
    }

    public boolean equals(Object o){
        if(o instanceof Player){
            Player p = (Player) o;
            return (this.id == p.id && this.first_name.equals(p.first_name) && this.last_name.equals(p.last_name) && this.codename.equals(p.codename));
        }
        return false;
    }
}
