package simulacao;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.core.utils.CoreUtils;
import br.com.davidbuzatto.jsge.core.utils.DrawingUtils;
import br.com.davidbuzatto.jsge.geom.Rectangle;
import br.com.davidbuzatto.jsge.image.Image;
import simulacao.entidades.Bola;

/**
 * Modelo de projeto básico da JSGE.
 * 
 * JSGE basic project template.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Main extends EngineFrame {

    public static final double GRAVIDADE = 20;

    private Bola bolinha;
    
    public Main() {
        
        super(
            800,                 // largura                      / width
            450,                 // algura                       / height
            "Bolinha",      // título                       / title
            60,                  // quadros por segundo desejado / target FPS
            true,                // suavização                   / antialiasing
            false,               // redimensionável              / resizable
            false,               // tela cheia                   / full screen
            false,               // sem decoração                / undecorated
            false,               // sempre no topo               / always on top
            false                // fundo invisível              / invisible background
        );
        
    }
    
    /**
     * Cria o mundo do jogo.
     * Esse método executa apenas uma vez durante a inicialização da engine.
     * 
     * Creates the game world.
     * This method runs just one time during engine initialization.
     */
    @Override
    public void create() {

        bolinha = new Bola(getScreenWidth()/2, getScreenHeight()/2, 50, 1000,  500);
       
    }

    
    @Override
    public void update( double delta ) {

        bolinha.atualizar(delta, this);        
        
    }
    
   
    @Override
    public void draw() {
        
        clearBackground( WHITE );
        
        bolinha.desenhar(this);
    
    }
    
   
    public static void main( String[] args ) {
        new Main();
    }
    
}
