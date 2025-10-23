package simulacao.entidades;
import simulacao.Main;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

public class Bola {

    private double x;
    private double y;
    private double rad;

    private double velX;
    private double velY;

    private double atrito;
    private double elasticidade;

    public Bola(double x, double y, double rad, double velX, double velY) {
        
        this.x = x;
        this.y = y;
        this.rad = rad;
        this.velX = velX;
        this.velY = velY;
        this.atrito = 0.99;
        this.elasticidade = 0.9;

    }
    
    public void atualizar(double delta, EngineFrame e){
        
        x+= velX * delta;
        
        y += velY * delta;
        
        if(x + rad >= e.getScreenWidth()){

            velX = -velX * elasticidade;

        }
        
        if(x - rad <= 0){

            velX = -velX* elasticidade;

        }

        if(y - rad <= 0){

            velY = -velY* elasticidade;

        }

        if(y + rad >= e.getScreenHeight()){

            velY = -velY * elasticidade;

        }

        velX = velX * atrito;
        velY = velY * atrito + Main.GRAVIDADE;
        

    }

    public void desenhar(EngineFrame e){

        e.fillCircle(x, y, rad, EngineFrame.BLACK);

    }

}
