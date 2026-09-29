package encapsulamento;
import javax.swing.JOptionPane;

public class alocaçãoservidornuvem {
    public static void main(String[] args) {
        
    
    String ip= JOptionPane.showInputDialog("digite o ip: ");
    int m = Integer.parseInt(JOptionPane.showInputDialog("digite a memoria disponivel: "));

    servidornuvem s = new servidornuvem(ip,m);
    gerenciaraloc g = new gerenciaraloc(s);

    int l = Integer.parseInt(JOptionPane.showInputDialog("digite quanto de memoria a tarefa usará: "));
    g.resumo(l);
}
}
class servidornuvem{
    private String ip;
    private int gb;
    public servidornuvem(String n, int gb){
        setip(n);
        setgb(gb);
    }
    public String getip(){
        return this.ip;
    }
    public int getgb(){
        return this.gb;
    }
    public void setip(String n){
        this.ip=n;
    }
    public void setgb(int gb){
        if(gb >=4){
            this.gb=gb;
        }else{
            JOptionPane.showMessageDialog(null,"memoria minima é 4gb.");
        }
    }

}
class gerenciaraloc{
    private servidornuvem servidor;
    public gerenciaraloc(servidornuvem s){
        this.servidor=s;
    }
    public boolean podeprocessar(int rn){
        if(this.servidor.getgb()>=rn){
            return true;
        }else{
            return false;
        }
    }
    public void resumo(int rn){
        String r = "=== RELATÓRIO DE ALOCAÇÃO ===\n "+
        "IP:"+this.servidor.getip()+"\n"+
        "RAM DISPONIVEL: "+this.servidor.getgb()+"\n"+
        "RAM NECESSARIA: "+rn+"\n"+
        "status:"+(podeprocessar(rn)?"maquina aguenta.":"maquina não aguenta.");
        JOptionPane.showMessageDialog(null, r);
    }
}
