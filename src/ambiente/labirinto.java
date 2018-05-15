
package ambiente;

import agente.AgenteLabirinto;
import geral.PosicaoXY;


public class labirinto {
    private int tamanhoLabirinto;
    
        private String[][] labirinto;
        
        private AgenteLabirinto agente;
    
    /* VALORES
     * S - SUJO   
     * L - LIMPO
     * A - AGENTE
    */
    public int getTamanho;
    public int getTamanho(){
    
    return this.tamanhoLabirinto;
    }
    
    
        
  // construir o labirinto toda vez q construir a classe      
  public labirinto(int tamanhoLabirinto){
   this.tamanhoLabirinto = tamanhoLabirinto;
   this.construirlabirinto();
  
  }
        
        
    // CONSTRUINDO O LABIRINTO
    private void construirlabirinto(){    
        labirinto = new String[tamanhoLabirinto][this.tamanhoLabirinto];
        for (int  i= 0; i < tamanhoLabirinto; i++){
            for (int j = 0; j < tamanhoLabirinto; j++){
                labirinto[i][j] = "S";
                }
            }
        }    
    
    public void exibirLabirinto(){
        atualizarPosicaoAgente();
        for (int  i= 0; i < tamanhoLabirinto; i++){
            for (int j = 0; j < tamanhoLabirinto; j++){
                if (labirinto[i][j].equals("*A*")){
                    System.out.print("|" + labirinto[i][j] + "|");
                }else{
                    System.out.print("| " + labirinto[i][j] + " |");
                }
                
                }
                    System.out.println("");
            }
                System.out.println("");
        }

    public String retornarValorPosicaoLabirinto(PosicaoXY posicao) {
        return this.labirinto[posicao.getPosX()][posicao.getPosY()];
    }

    public void setAgente(AgenteLabirinto agente) {
        this.agente = agente;
    }

    public void limpar() {
        PosicaoXY posicao = this.agente.getPosicao();
        labirinto[posicao.getPosX()][posicao.getPosY()] = " L ";
    }

    private void atualizarPosicaoAgente() {
        if (this.agente != null){
       PosicaoXY posAgente = this.agente.getPosicao();
       
       labirinto[posAgente.getPosX()][posAgente.getPosY()] = "*A*";
    }

    
    }

    public int getTamanhoLabirinto() {
        return this.tamanhoLabirinto;
    
    }

   
}

