
package principal;

import agente.AgenteLabirinto;
import ambiente.labirinto;
import geral.PosicaoXY;


public class inteligenciaArtificial {
    
    public static void main(String[] args) throws InterruptedException{
        
        labirinto labirinto = new  labirinto(4);
        labirinto.exibirLabirinto();

        AgenteLabirinto agente = new AgenteLabirinto(labirinto);
        agente.setPosicao(new PosicaoXY(3,0));
        
        while(agente.isAindaLimpando()){ 
            agente.zerarPilha();
            agente.movimentar();
            labirinto.exibirLabirinto();
            Thread.sleep(1500);
            
                    
            
        
        
        }
        return;
    }
}
    