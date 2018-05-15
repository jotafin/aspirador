
package agente;

import ambiente.labirinto;
import geral.PosicaoXY;


public class AgenteLabirinto {
    
    // MOVIMENTAR PARA 4 DIREÇÕES(cima, baixo, esquerda, direita)
    // REFERENCIA DO LABIRINTO (para saber onde ele ta passando)
    
    private labirinto labirinto;
    private MovimentoAgenteLabirinto movimento;
    
   //posição X e Y para saber onde vai tar o agente 
    private PosicaoXY posXY;
    //para nao dar estouro de pilha, para ele nao parar
    private int pilhaMovimentos;
    
    public AgenteLabirinto(labirinto labirinto){
        this.labirinto = labirinto;
        labirinto.setAgente(this);
        this.posXY = new PosicaoXY();
        this.movimento = MovimentoAgenteLabirinto.CIMA;
    }
    
    public void movimentar(){
        if (this.pilhaMovimentos >= 4){
            return;
        }
        
        
        PosicaoXY proximoMovimento = retornarMovimento();
    
    String valor = this.labirinto.retornarValorPosicaoLabirinto(proximoMovimento);
    
        if (valor.equals(" L ") || valor.equals("*A*")){
            proximoMovimento();
            aumentarPilha();
            movimentar();
        }else{
            this.labirinto.limpar();
            this.posXY = proximoMovimento;
        }
    }
        private void aumentarPilha() {
           // FICA SABENDO QUAL O TAMANHO DELE, tamanho maximo q pode ter
            this.pilhaMovimentos++; 
            
            
        }
        private void proximoMovimento() {
            switch(this.movimento){
                case CIMA:
                    this.movimento = MovimentoAgenteLabirinto.BAIXO;
                    break;
                case BAIXO:
                    this.movimento = MovimentoAgenteLabirinto.ESQUERDA;
                    break;
                case ESQUERDA:
                    this.movimento = MovimentoAgenteLabirinto.DIREITA;
                    break;
                case DIREITA:
                    this.movimento = MovimentoAgenteLabirinto.CIMA;
                    break;
            
            }
            
        }
    
    public PosicaoXY retornarMovimento(){
    
        int retornoPosX = this.posXY.getPosX();
        int retornoPosY = this.posXY.getPosY();
        
        //
        switch(movimento){
            case CIMA:
            if (retornoPosX > 0){
                retornoPosX -= 1;
            }
            break;
            case BAIXO:
            if (retornoPosX  < this.labirinto.getTamanhoLabirinto() - 1){
                    retornoPosX += 1;
            }
            break;
            case ESQUERDA:
            if (retornoPosY > 0){
                retornoPosY -= 1;
            }
            break;
            case DIREITA:
            if (retornoPosY < this.labirinto.getTamanhoLabirinto() - 1){
                retornoPosY += 1;
            }
            break;
        }
            return new PosicaoXY(retornoPosX, retornoPosY);
    }

    public PosicaoXY getPosicao() {
        return this.posXY;
    }

    public boolean isAindaLimpando() {
         return pilhaMovimentos < 4;
    }

    public void zerarPilha() {
        this.pilhaMovimentos = 0;
    }

    public void setPosicao(PosicaoXY posicaoXY) {
        this.posXY = posicaoXY;
    }

    

   

    
    

}

