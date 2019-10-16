/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendar;

import Calendar.cholqij.ManejadorCalendarioCholqij;
import GUI.MainFrame;
import Haab.Dia_Haab;
import Haab.Kin_Haab;
import Haab.Mes_Haab;
import MVC.ManejadorHaab;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author bryan
 */
public class Matriz extends JPanel implements ActionListener,ComponentListener{
    
    private JButton[][] mCasillas;
    private int nFilas;
    private int mColumnas;
    private int rCasillas;
    private EnumMatriz tipo;
    //private ConstanteFaseLunar constLunar;
    private ManejadorHaab manejadorHab;
    private ManejadorCalendarioCholqij manejadorCholqij;
    private MainFrame frame;
    
    //en lugar del enum podria mejor traer un tipo de calendario
    public Matriz(MainFrame frame, int nFilas, int mColumnas, int rCasillas, EnumMatriz tipo) {
        this.frame = frame;
        this.mCasillas = null;
        this.nFilas = nFilas;
        this.mColumnas = mColumnas;
        this.rCasillas = rCasillas;
        this.tipo= tipo;
        this.setLayout(null);
        this.setBackground(Color.GRAY);
        this.addComponentListener(this);
        
    }
    
    public void ordenar(){
        int anchoTotal = this.getWidth();
        int altoTotal = this.getHeight();
        int anchoDeCasilla = anchoTotal/mColumnas;
        int altoDeCasilla = altoTotal/nFilas;
        for (int fila = 0; fila < nFilas; fila++) {
            for (int columna = 0; columna < mColumnas; columna++) {
                //obtenemos referencia al boton actual
                JButton temp = mCasillas[fila][columna];
                //fijar cada casilla
                temp.setBounds(columna*anchoDeCasilla, fila*altoDeCasilla, anchoDeCasilla, altoDeCasilla);
            }
        }
    }
    
    public void inicializar(){
        switch (tipo) {
            case HAAB:
                colocarCasillasHabb();
                break;
            case CHOLQUIJ:
                colocarCasillasCholqij();
                //
                break;
            case LUNAR:
                colocarCasillasFaseLunar();
                //
                break;
            default:
                throw new AssertionError();
        }
    }
    public void colocarCasillasHabb(){
        CalendarioHaab cal= new CalendarioHaab(true);
        manejadorHab = new ManejadorHaab();
        Kin_Haab[][] kinHaab2= manejadorHab.getDiaCero();
        
        Kin_Haab[][] kinHaab= cal.getFechaExacta();
        int casilla = 0;
        mCasillas = new JButton[nFilas][mColumnas];
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < mColumnas; j++) {
                //constLunar = new ConstanteFaseLunar(casilla);  IR A LA BD A TRAER ESA INFO
                
                JButton temp = new JButton();
                    
                if (casilla<=rCasillas) {
                    //establecerAtributosCasilla(temp, new ImageIcon(constLunar.obtenerRutaImagen()), casilla);
                    temp.setName(""+casilla);
                    this.add(temp);
                }
                     
                mCasillas[i][j] = temp;
                casilla ++;
            }
        }
    }
    public void colocarCasillasCholqij(){
        //CalendarioHaab cal= (CalendarioHaab)calendario;
        manejadorCholqij= new ManejadorCalendarioCholqij();
        
        int casilla = 0;
        mCasillas = new JButton[nFilas][mColumnas];
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < mColumnas; j++) {
                //constLunar = new ConstanteFaseLunar(casilla);  IR A LA BD A TRAER ESA INFO
                
                JButton temp = new JButton();
                
                if (casilla<=rCasillas) {
                    //establecerAtributosCasilla(temp, new ImageIcon(constLunar.obtenerRutaImagen()), casilla);
                    temp.setName(""+casilla);
                    this.add(temp);
                }
                     
                mCasillas[i][j] = temp;
                casilla ++;
            }
        }
    }
    public void colocarCasillasFaseLunar(){
        //CalendarioHaab cal= (CalendarioHaab)calendario;
        manejadorHab = new ManejadorHaab();
        
        int casilla = 0;
        mCasillas = new JButton[nFilas][mColumnas];
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < mColumnas; j++) {
                //constLunar = new ConstanteFaseLunar(casilla);  IR A LA BD A TRAER ESA INFO       
                JButton temp = new JButton();
                
                if (casilla<=rCasillas) {
                    //establecerAtributosCasilla(temp, new ImageIcon(constLunar.obtenerRutaImagen()), casilla);
                    temp.setName(""+casilla);
                    this.add(temp);
                }
                     
                mCasillas[i][j] = temp;
                casilla ++;
            }
        }
    }
    
    public void establecerAtributosCasilla(JButton temp, ImageIcon icon, int fase){
        //ImageIcon icon = new ImageIcon(constLunar.obtenerRutaImagen());
        temp.setForeground(Color.RED);
        temp.setBorder(new BevelBorder(1));
        temp.setIcon(icon);
        
        temp.setIconTextGap(1);
        temp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        temp.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        temp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        temp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        temp.setText("Fase_"+fase);
        //lanzando evento de cada boton
        temp.addActionListener(this);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //boton presionado
        if (e.getSource() instanceof JButton) {
            JButton temp = (JButton)e.getSource();
            //temp.setBackground(Color.YELLOW);
            System.out.println(""+temp.getName());
            //InfoFaseLunar info = new InfoFaseLunar(frame, Integer.parseInt(temp.getName()));
            //info.setVisible(true);
            
        }
        
    }

    @Override
    public void componentResized(ComponentEvent e) {
        this.ordenar();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentShown(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
