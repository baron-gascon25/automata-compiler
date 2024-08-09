/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compiler;

/**
 *
 * @author Baron
 */
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Edge;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class simulation {
    
    public void startReg1 (String regIn){
        new Thread (() -> {
            regSim1(regIn);
    }).start();}
    
    public void startReg2 (String regIn){
        new Thread (() -> {
            regSim2(regIn);
    }).start();}
    
    public void regSim2 (String regIn){
        
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("DFA2");
        
        graph.setAttribute("ui.stylesheet", "node{size: 30px; text-size: 18px; text-color: white; stroke-mode: plain; }" + "edge{text-size: 20px;}" + "node.deactivate {fill-color:black;}" + "node.activate {fill-color: purple;}");
        
        Node node0 = graph.addNode("0");
        node0.setAttribute("layout.frozen");
        node0.setAttribute("xy",0,0);
        node0.setAttribute("label", "0");
        
        Node node1 = graph.addNode("1");
        node1.setAttribute("layout.frozen");
        node1.setAttribute("xy",1,0);
        node1.setAttribute("label", "1");
        
        Node node2 = graph.addNode("2");
        node2.setAttribute("layout.frozen");
        node2.setAttribute("xy",2,1);
        node2.setAttribute("label", "2");
        
        Node node3 = graph.addNode("3");
        node3.setAttribute("layout.frozen");
        node3.setAttribute("xy",3,0);
        node3.setAttribute("label", "3");
        
        Node node4 = graph.addNode("4");
        node4.setAttribute("layout.frozen");
        node4.setAttribute("xy",3,1);
        node4.setAttribute("label", "4");
        
        Node node5 = graph.addNode("5");
        node5.setAttribute("layout.frozen");
        node5.setAttribute("xy",5,1);
        node5.setAttribute("label", "5");
        
        Node node6 = graph.addNode("6");
        node6.setAttribute("layout.frozen");
        node6.setAttribute("xy",4,0);
        node6.setAttribute("label", "6");
        
        Node node7 = graph.addNode("7");
        node7.setAttribute("layout.frozen");
        node7.setAttribute("xy",4,-1);
        node7.setAttribute("label", "7"); 
        
        Edge edge0 = graph.addEdge("01","0","1",true);
        edge0.setAttribute("ui.label", "0,1");
        
        Edge edge1 = graph.addEdge("12","1","2",true);
        edge1.setAttribute("ui.label", "0");
        
        Edge edge2 = graph.addEdge("13","1","3",true);
        edge2.setAttribute("ui.label", "1");
        
        Edge edge3 = graph.addEdge("24","2","4",true);
        edge3.setAttribute("ui.label", "0");
        
        Edge edge4 = graph.addEdge("23","2","3",true);
        edge4.setAttribute("ui.label", "1");
        
        Edge edge5 = graph.addEdge("34","4","3",true);
        edge5.setAttribute("ui.label", "1");
        
        Edge edge6 = graph.addEdge("45","4","5",true);
        edge6.setAttribute("ui.label", "0");
        
        Edge edge7 = graph.addEdge("46","6","4",true);
        edge7.setAttribute("ui.label", "0");
        
        Edge edge8 = graph.addEdge("36","3","6",true);
        edge8.setAttribute("ui.label", "0");
        
        Edge edge9 = graph.addEdge("65","6","5",true);
        edge9.setAttribute("ui.label", "1");
        
        Edge edge10 = graph.addEdge("37","3","7",true);
        edge10.setAttribute("ui.label", "1");
        
        Edge edge11 = graph.addEdge("76","7","6",true);
        edge11.setAttribute("ui.label", "0");
        
        Edge edge12 = graph.addEdge("75","7","5",true);
        edge12.setAttribute("ui.label", "1");
        
        Edge edge13 = graph.addEdge("55","5","5",true);
        edge13.setAttribute("ui.label", "0,1");
        
        Viewer viewer = graph.display();
        viewer.disableAutoLayout();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        
        String regEx = regIn;
        int counter = 0;
        int currentState = 0;
        int maxLength = regEx.length();
        activateNode(node0);
        do {
            char currentLetter = regEx.charAt(counter);
            counter++;
            
            switch(currentState)
            {
                case 0:
                    if(currentLetter == '0' || currentLetter == '1')
                    {
                        currentState = 1;
                        activateNode(node1);
                    }

                    break;
                case 1:
                    if (currentLetter == '1')
                    {
                        currentState = 3;
                        activateNode(node3);
                    }
                    else if (currentLetter == '0')
                    {
                        currentState = 2;
                        activateNode(node2);
                    }
                    break;
                case 2:
                    if (currentLetter == '1')
                    {
                        currentState = 3;
                        activateNode(node3);
                    }
                    else if (currentLetter == '0')
                    {
                        currentState = 4;
                        activateNode(node4);
                    }
                    break;
                case 3:
                    if (currentLetter == '1')
                    {
                        currentState = 7;
                        activateNode(node7);
                    }
                    else if (currentLetter == '0')
                    {
                        currentState = 6;
                        activateNode(node6);
                    }
                    break;
                case 4:
                    if (currentLetter == '1')
                    {
                        currentState = 3;
                        activateNode(node3);
                    }
                    else if (currentLetter == '0')
                    {
                        currentState = 5;
                        activateNode(node5);
                    }
                    break;
                case 5:
                    if (currentLetter == '0' || currentLetter == '1')
                    {
                        currentState = 5;
                        activateNode(node5);
                    }
                    break;
                case 6:
                    if (currentLetter == '1')
                    {
                        currentState = 5;
                        activateNode(node5);
                    }
                    else if (currentLetter == '0')
                    {
                        currentState = 4;
                        activateNode(node4);
                    }
                    break;
                case 7:
                    if (currentLetter == '1')
                    {
                        currentState = 5;
                        activateNode(node5);
                    }
                    else if (currentLetter == '0')
                    {
                        currentState = 6;
                        activateNode(node6);
                    }
                    break;
            }
        }
        while(counter < maxLength);
    }
      
    public void regSim1(String regIn){
            
            
            System.setProperty("org.graphstream.ui", "swing");
            Graph graph = new SingleGraph("DFA1");
            
            graph.setAttribute("ui.stylesheet", "node{size: 30px; text-size: 18px; text-color: white; stroke-mode: plain; }" + "edge{text-size: 20px;}" + "node.deactivate {fill-color:black;}" + "node.activate {fill-color: purple;}");
            
            Node node0 = graph.addNode("0");
            node0.setAttribute("layout.frozen");
            node0.setAttribute("xy",0,0);
            node0.setAttribute("label", "0");
            
            Node node1 = graph.addNode("1");
            node1.setAttribute("layout.frozen");
            node1.setAttribute("xy",1,1);
            node1.setAttribute("label", "1");
            
            Node node2 = graph.addNode("2");
            node2.setAttribute("layout.frozen");
            node2.setAttribute("xy",2,1);
            node2.setAttribute("label", "2");
            
            Node node3 = graph.addNode("3");
            node3.setAttribute("layout.frozen");
            node3.setAttribute("xy",1,-1);
            node3.setAttribute("label", "3");
            
            Node node4 = graph.addNode("4");
            node4.setAttribute("layout.frozen");
            node4.setAttribute("xy",2,-1);
            node4.setAttribute("label", "4");
            
            Node node5 = graph.addNode("5");
            node5.setAttribute("layout.frozen");
            node5.setAttribute("xy",1.5,0);
            node5.setAttribute("label", "5");
            
            Node node6 = graph.addNode("6");
            node6.setAttribute("layout.frozen");
            node6.setAttribute("xy",3,0);
            node6.setAttribute("label", "6");
            
            Node node7 = graph.addNode("7");
            node7.setAttribute("layout.frozen");
            node7.setAttribute("xy",4,0);
            node7.setAttribute("label", "7");
            
            Node node8 = graph.addNode("8");
            node8.setAttribute("layout.frozen");
            node8.setAttribute("xy",5,0);
            node8.setAttribute("label", "8");
            
            Node node9 = graph.addNode("9");
            node9.setAttribute("layout.frozen");
            node9.setAttribute("xy",6,0);
            node9.setAttribute("label", "9");
            
            Node node10 = graph.addNode("10");
            node10.setAttribute("layout.frozen");
            node10.setAttribute("xy",7,0);
            node10.setAttribute("label", "10");
            
            Edge edge0b = graph.addEdge("01","0","1",true);
            edge0b.setAttribute("ui.label", "b");
            
            Edge edge0a = graph.addEdge("03","0","3",true);
            edge0a.setAttribute("ui.label", "a");
            
            Edge edge1a = graph.addEdge("12", "1", "2", true);
            edge1a.setAttribute("ui.label", "a");
            
            Edge edge1b = graph.addEdge("15", "1", "5", true);
            edge1b.setAttribute("ui.label", "b");
            
            Edge edge2a = graph.addEdge("25", "2", "5", true);
            edge2a.setAttribute("ui.label", "a");
            
            Edge edge2b = graph.addEdge("26", "2", "6", true);
            edge2b.setAttribute("ui.label", "b");
            
            Edge edge3a = graph.addEdge("35", "3", "5", true);
            edge3a.setAttribute("ui.label", "a");
            
            Edge edge3b = graph.addEdge("34", "3", "4", true);
            edge3b.setAttribute("ui.label", "b");
            
            Edge edge4b = graph.addEdge("45", "4", "5",true);
            edge4b.setAttribute("ui.label", "b");
            
            Edge edge4a = graph.addEdge("46", "4", "6",true);
            edge4a.setAttribute("ui.label", "a");
            
            Edge edge6a = graph.addEdge("6", "6", "6",true);
            edge6a.setAttribute("ui.label", "a");
            edge6a.setAttribute("ui.style", "text-offset: 30px,-40px;");
            
            Edge edge6b = graph.addEdge("67", "6", "7",true);
            edge6b.setAttribute("ui.label", "b");
            edge6b.setAttribute("ui.style", "text-offset: -20px,20px;");
            
            Edge edge7a = graph.addEdge("86", "8", "6",true);
            edge7a.setAttribute("ui.label", " a");
            edge7a.setAttribute("ui.style", "text-offset: 20px,60px;");
            
            Edge edge7b = graph.addEdge("77", "7", "7",true);
            edge7b.setAttribute("ui.label", "b");
            edge7b.setAttribute("ui.style", "text-offset: 40px,-40px;");
            
            Edge edge7 = graph.addEdge("78", "7", "8",true);
            edge7.setAttribute("ui.label", "a");
            
            Edge edge8 = graph.addEdge("89", "8", "9",true);
            edge8.setAttribute("ui.label", "b");
            
            Edge edge9 = graph.addEdge("910", "9", "10",true);
            edge9.setAttribute("ui.label", "a,b");
            
            Edge edge10 = graph.addEdge("1010", "10", "10",true);
            edge10.setAttribute("ui.label", "a,b");
            
            Viewer viewer = graph.display();
            viewer.disableAutoLayout();
            viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
            
        String regEx = regIn;
        int counter = 0;
        int currentState = 0;
        int maxLength = regEx.length();
              activateNode(node0);
        do{
            char currentLetter = regEx.charAt(counter);
            counter++;
            
        switch(currentState)
        {
            case 0:
                
                if (currentLetter == 'a')
                {
                    currentState = 3;
                    activateNode(node3);
                }
                else if (currentLetter == 'b')
                {
                    currentState = 1;
                    activateNode(node1);
                }
                break;
            case 1:
                
                if (currentLetter == 'a')
                {
                    currentState = 2;
                    activateNode(node2);
                }
                else if (currentLetter == 'b')
                {
                    currentState = 5;
                    activateNode(node5);            
                }
                break;
            case 2:
                
                if (currentLetter == 'a')
                {
                    currentState = 5;
                    activateNode(node5);
                }
                else if (currentLetter == 'b')
                {
                    currentState = 6;
                    activateNode(node6);            
                }
                break;
            case 3:
                
                if (currentLetter == 'a')
                {
                    currentState = 5;
                    activateNode(node5);
                }
                else if (currentLetter == 'b')
                {
                    currentState = 4;
                    activateNode(node4);
                }
                break;
            case 4:
                
                if (currentLetter == 'b')
                {
                    currentState = 5;
                    activateNode(node5);
                }
                else if (currentLetter == 'a')
                {
                    currentState = 6;
                    activateNode(node6);
                }
                break;
            case 5:
                
                if (currentLetter == 'a' || currentLetter == 'b')
                {
                    currentState = 5;
                    activateNode(node5);
                }
                break;
            case 6:
                
                if (currentLetter == 'a')
                {
                    currentState = 6;
                    activateNode(node6);
                }
                else if (currentLetter == 'b')
                {
                    currentState = 7;
                    activateNode(node7);
                }
                break;
            case 7:
                
                if (currentLetter == 'a')
                {
                    currentState = 8;
                    activateNode(node8);
                }
                else if (currentLetter == 'b')
                {
                    currentState = 7;
                    activateNode(node7);
                }
                break;
            case 8:
                
                if (currentLetter == 'b')
                {
                    currentState = 9;
                    activateNode(node9);
                }
                else if (currentLetter == 'a')
                {
                    currentState = 6;
                    activateNode(node6);
                }
                
                break;
            case 9:
                
                if (currentLetter == 'a' || currentLetter == 'b')
                {
                    currentState = 10;
                    activateNode(node10);
                }
                
                break;
            case 10:
                
                if (currentLetter == 'a' || currentLetter == 'b')
                {
                    currentState = 10;
                    activateNode(node10);
                }
                break;
        }

    } while(counter < maxLength);
    
    }
     
    public static void activateNode (Node nodeToChange){
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        nodeToChange.setAttribute("ui.class", "deactivate");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        nodeToChange.setAttribute("ui.class", "activate");
    }
}
