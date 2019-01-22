/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/
package Controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.*;
import Model.CyclicBarrier.*;
import Model.Expression.*;
import Model.File.FileTable;
import Model.File.OpenFile;
import Model.Heap.Heap;
import Model.Heap.NewHeap;
import Model.Heap.ReadHeap;
import Model.Heap.WriteHeap;
import Model.LatchTable.ILatchTable;
import Model.LatchTable.LatchTable;
import Model.LockTable.*;
import Model.Statement.*;
import Repository.IPrgStateRepo;
import Repository.PrgStateRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.EventHandler;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerGUI implements Initializable
{
    private int goInLL = 0;

    @FXML private ListView<String> view;

    @FXML private Button OneStepButton;

    @FXML private Button LoadButton;

    @FXML private Label NoOfThreadsLabel;

    @FXML private ListView<String> ExeStackList;

    @FXML private ListView outputListList;

    @FXML private ListView PrgStateIdentifierList;

    @FXML private TableView<TableViewSymbolT> SymbolTableTable;
    @FXML private TableColumn<TableViewSymbolT, String> Variable;
    @FXML private TableColumn<TableViewSymbolT, Integer> ValueS;

    @FXML private TableView<TableViewHeap> HeapTable;
    @FXML private TableColumn<TableViewHeap, Integer> Address;
    @FXML private TableColumn<TableViewHeap, Integer> ValueH;

    @FXML private TableView<TableViewFileTable> FileTableTable;
    @FXML private TableColumn<TableViewFileTable, Integer> Identifier;
    @FXML private TableColumn<TableViewFileTable, String> fileName;

    @FXML private TableView<TableViewLockTable> LockTableTable;
    @FXML private TableColumn<TableViewLockTable, Integer> LLIdentifier;
    @FXML private TableColumn<TableViewLockTable, Integer> LLValue;

    @FXML private TableView<TableViewCyclicBarrier> CyclicBarrierTable;
    @FXML private TableColumn<TableViewLockTable, Integer> LocationBar;
    @FXML private TableColumn<TableViewLockTable, Integer> ValueBar;
    @FXML private TableColumn<TableViewLockTable, ArrayList<Integer>> ThreadsList;

    private IPrgStateRepo repo = new PrgStateRepo("programs.txt");
    private Controller ctrl = new Controller(repo);

    @FXML
    private void buttonHandler()
    {
        int idx = view.getSelectionModel().getSelectedIndex();
        if(idx >= 0)
        {
            Boolean isDone = true;
            for (PrgState prg : repo.getPrgList())
                if (prg.isNotCompleted())
                    isDone = false;

            if (!isDone)
            {
                int x = ctrl.oneStepGUI();
                NoOfThreadsLabel.setText("Number of threads: " + String.valueOf(x));
                setPrgStateIdentifiers();
                setExeStackList();
                setOutputList();
                setSymbolT();
                setHeap();
                setFileTable();
                setCyclicBarrierTable();
                if (goInLL == 1)
                    setLockTable();
            }
            else { EmptyStackAllert(); }
        }
        else { IndexAllert(); }
    }

    @FXML
    private void buttonHandlerLoad()
    {
        int idx = view.getSelectionModel().getSelectedIndex();
        if(idx >= 0)
        {
            String s = view.getSelectionModel().getSelectedItem();
            setPrgState(s);
            setPrgStateIdentifiers();
            LoadAllert();
        }
        else { IndexAllert(); }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        ObservableList<String> items = FXCollections.observableArrayList();
        items.add(prg1().getStatement().toString());
        items.add(prg2().getStatement().toString());
        items.add(prg3().getStatement().toString());
        items.add(prg4().getStatement().toString());
        items.add(prg5().getStatement().toString());
        items.add(prg6().getStatement().toString());
        items.add(prg7().getStatement().toString());
        items.add(prg8().getStatement().toString());
        items.add(prg9().getStatement().toString());
        items.add(prg10().getStatement().toString());
        items.add(prg11().getStatement().toString());
        items.add(prg12().getStatement().toString());
        view.setItems(items);

        Variable.setCellValueFactory(new PropertyValueFactory<>("varName"));
        ValueS.setCellValueFactory(new PropertyValueFactory<>("value"));
        Address.setCellValueFactory(new PropertyValueFactory<>("address"));
        ValueH.setCellValueFactory(new PropertyValueFactory<>("value"));
        Identifier.setCellValueFactory(new PropertyValueFactory<>("key"));
        fileName.setCellValueFactory(new PropertyValueFactory<>("name"));
        LLIdentifier.setCellValueFactory(new PropertyValueFactory<>("identifier"));
        LLValue.setCellValueFactory(new PropertyValueFactory<>("value"));
        LocationBar.setCellValueFactory(new PropertyValueFactory<>("index"));
        ValueBar.setCellValueFactory(new PropertyValueFactory<>("value"));
        ThreadsList.setCellValueFactory(new PropertyValueFactory<>("list"));

        NoOfThreadsLabel.setText("Number of threads: " + String.valueOf(0));

        LoadButton.setOnAction(new EventHandler<ActionEvent>()
                                  {
                                      @Override
                                      public void handle(ActionEvent event)
                                      {
                                          buttonHandlerLoad();
                                      }
                                  }
        );

        OneStepButton.setOnAction(new EventHandler<ActionEvent>()
                                  {
                                      @Override
                                      public void handle(ActionEvent event)
                                      {
                                          buttonHandler();
                                      }
                                  }
        );
    }

    private void LoadAllert()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Statement loaded !");
        alert.show();
    }

    private void IndexAllert()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error !");
        alert.setHeaderText(null);
        alert.setContentText("Select a statement !");
        alert.show();
    }

    private void EmptyStackAllert()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error !");
        alert.setHeaderText(null);
        alert.setContentText("Nothing to execute !");
        alert.show();
    }

    private void setPrgState(String str)
    {
        PrgState p1 = prg1();
        PrgState p2 = prg2();
        PrgState p3 = prg3();
        PrgState p4 = prg4();
        PrgState p5 = prg5();
        PrgState p6 = prg6();
        PrgState p7 = prg7();
        PrgState p8 = prg8();
        PrgState p9 = prg9();
        PrgState p10 = prg10();
        PrgState p11 = prg11();
        PrgState p12 = prg12();
        if (p1.getStatement().toString().equals(str))
        {
            repo.addPrgState(p1);
            goInLL = 0;
        }
        else if (p2.getStatement().toString().equals(str))
        {
            repo.addPrgState(p2);
            goInLL = 0;
        }
        else if (p3.getStatement().toString().equals(str))
        {
            repo.addPrgState(p3);
            goInLL = 0;
        }
        else if (p4.getStatement().toString().equals(str))
        {
            repo.addPrgState(p4);
            goInLL = 0;
        }
        else if (p5.getStatement().toString().equals(str))
        {
            repo.addPrgState(p5);
            goInLL = 0;
        }
        else if (p6.getStatement().toString().equals(str))
        {
            repo.addPrgState(p6);
            goInLL = 0;
        }
        else if (p7.getStatement().toString().equals(str))
        {
            repo.addPrgState(p7);
            goInLL = 0;
        }
        else if (p8.getStatement().toString().equals(str))
        {
            repo.addPrgState(p8);
            goInLL = 0;
        }
        else if (p9.getStatement().toString().equals(str))
        {
            repo.addPrgState(p9);
            goInLL = 1;
        }
        else if (p10.getStatement().toString().equals(str))
        {
            repo.addPrgState(p10);
            goInLL = 0;
        }
        else if (p11.getStatement().toString().equals(str))
        {
            repo.addPrgState(p11);
            goInLL = 0;
        }
        else if (p12.getStatement().toString().equals(str))
        {
            repo.addPrgState(p12);
            goInLL = 0;
        }
        setPrgStateIdentifiers();
    }

    private void setPrgStateIdentifiers()
    {
        ObservableList<String> items = FXCollections.observableArrayList();
        items.add(String.valueOf(repo.getCurrentProgram().getID()));
        PrgStateIdentifierList.setItems(items);
    }

    private void setExeStackList()
    {
        ObservableList<String> items = FXCollections.observableArrayList();
        PrgState p = repo.getCurrentProgram();
        for(Statement s : p.getExecStack().getAll())
            items.add("" + s);
        ExeStackList.setItems(items);
    }

    private void setOutputList()
    {
        ObservableList<String> list = FXCollections.observableArrayList();
        PrgState p = repo.getCurrentProgram();
        for(Integer i: p.getList().getAll())
            list.add("" + i);
        outputListList.setItems(list);
    }

    private void setSymbolT()
    {
        ObservableList<TableViewSymbolT> list = FXCollections.observableArrayList();
        PrgState p = repo.getCurrentProgram();
        for(String key: p.getSymbolT().getAll())
            list.add(new TableViewSymbolT(key, p.getSymbolT().get(key)));
        SymbolTableTable.setItems(list);
    }

    private void setCyclicBarrierTable()
    {
        ObservableList<TableViewCyclicBarrier> list = FXCollections.observableArrayList();
        PrgState p = repo.getCurrentProgram();
        for (Integer key: p.getCyclicBarrier().getAll())
            list.add(new TableViewCyclicBarrier(key, p.getCyclicBarrier().get(key).getFirst(), p.getCyclicBarrier().get(key).getSecond().toString()));
        CyclicBarrierTable.setItems(list);
    }

    private void setHeap()
    {
        ObservableList<TableViewHeap> list = FXCollections.observableArrayList();
        PrgState p = repo.getCurrentProgram();
        for(Integer key: p.getHeap().getKeys())
            list.add(new TableViewHeap(key, p.getHeap().get(key)));
        HeapTable.setItems(list);
    }

    private void setLockTable()
    {
        ObservableList<TableViewLockTable> list = FXCollections.observableArrayList();
        PrgState p = repo.getCurrentProgram();
        for(Integer key: p.getLockTable().getKeys())
            list.add(new TableViewLockTable(key, p.getLockTable().get(key)));
        LockTableTable.setItems(list);
    }

    private void setFileTable()
    {
        ObservableList<TableViewFileTable> list = FXCollections.observableArrayList();
        PrgState p = repo.getCurrentProgram();
        for(Integer key: p.getFileTable().getAll())
        {
            String fn = p.getFileTable().get(key).toString();
            list.add(new TableViewFileTable(key, fn));
        }
        FileTableTable.setItems(list);
    }

    private PrgState prg1()
    {
        //a=5;
        //if (a-5) then
        //    print(1);
        //else
        //    print(2);
        //print((5+7)a);

        Statement ex1 = new CompStmt(
                new AssignStmt("a", new ConstExpr(5)),
                new CompStmt(
                        new IfStmt(
                                new ArithmeticExpr(
                                        '-',
                                        new VarExpr("a"),
                                        new ConstExpr(5)
                                ),
                                new PrintStmt(new ConstExpr(1)),
                                new PrintStmt(new ConstExpr(2))
                        ),
                        new PrintStmt(
                                new ArithmeticExpr(
                                        '*',
                                        new ArithmeticExpr(
                                                '+',
                                                new ConstExpr(5),
                                                new ConstExpr(7)
                                        ),
                                        new VarExpr("a")
                                )
                        )
                )
        );
        ILatchTable<Integer,Integer> latchTable = new LatchTable<>();
        ILockTable<Integer, Integer> lockTable = new LockTable<>();
        IExecStack<Statement> stack1 = new ExeStack<>();
        IDictionary<String, Integer> dict1 = new Dictionary<>();
        IList<Integer> l1 = new outputList<>();
        stack1.push(ex1);
        PrgState p = new PrgState(stack1, dict1, l1, new FileTable<>(), new Heap<>(), 1, ex1, lockTable, new CyclicBarrier<>(), latchTable);
        return p;
    }

    private PrgState prg2()
    {
        /*
        a=2-2;
        If a Then
            v=2
        Else
            v=3;
        Print(v)
         */

        Statement ex2 = new CompStmt(
                new AssignStmt("a",
                        new ArithmeticExpr('-',
                                new ConstExpr(2),
                                new ConstExpr(2))),
                new CompStmt(
                        new IfStmt(
                                new VarExpr("a"),
                                new AssignStmt("v",
                                        new ConstExpr(2)),
                                new AssignStmt("v",
                                        new ConstExpr(3))),
                        new PrintStmt(
                                new VarExpr("v"))));

        ILatchTable<Integer,Integer> latchTable = new LatchTable<>();
        ILockTable<Integer, Integer> lockTable = new LockTable<>();
        IExecStack<Statement> stack1 = new ExeStack<>();
        IDictionary<String, Integer> dict1 = new Dictionary<>();
        IList<Integer> l1 = new outputList<>();
        stack1.push(ex2);
        PrgState p = new PrgState(stack1, dict1, l1, new FileTable<>(), new Heap<>(), 2, ex2, lockTable, new CyclicBarrier<>(), latchTable);
        return p;
    }

    private PrgState prg3()
    {
        //v = 10;
        //newH(v,20);
        //newH(a,22);
        //wH(a,30);
        //print(a);
        //print(rH(a));
        //a = 0

        Statement ex3 = new CompStmt(
                new CompStmt(
                        new CompStmt(
                                new AssignStmt("v", new ConstExpr(10)),
                                new NewHeap("v", new ConstExpr(20))
                        ),
                        new CompStmt(
                                new NewHeap("a", new ConstExpr(22)),
                                new WriteHeap("a", new ConstExpr(30))
                        )
                ),
                new CompStmt(
                        new CompStmt(
                                new PrintStmt(new VarExpr("a")),
                                new PrintStmt(new ReadHeap("a"))
                        ),
                        new AssignStmt("a", new ConstExpr(0))
                )
        );

        ILatchTable<Integer,Integer> latchTable = new LatchTable<>();
        ILockTable<Integer, Integer> lockTable = new LockTable<>();
        IExecStack<Statement> stack1 = new ExeStack<>();
        IDictionary<String, Integer> dict1 = new Dictionary<>();
        IList<Integer> l1 = new outputList<>();
        stack1.push(ex3);
        PrgState p = new PrgState(stack1, dict1, l1, new FileTable<>(), new Heap<>(), 3, ex3, lockTable,new CyclicBarrier<>(), latchTable);
        return p;
    }

    private PrgState prg4()
    {
        //open(a,"a.txt")
        //open(b,"b.txt")
        //open(c,"c.txt")
        //open(d,"d.txt")

        Statement ex4 = new CompStmt(
                new CompStmt(
                        new OpenFile("a", "a.txt"),
                        new OpenFile("b", "b.txt")
                ),
                new CompStmt(
                        new OpenFile("c", "c.txt"),
                        new OpenFile("d", "d.txt")
                )
        );

        ILatchTable<Integer,Integer> latchTable = new LatchTable<>();
        ILockTable<Integer, Integer> lockTable = new LockTable<>();
        IExecStack<Statement> stack1 = new ExeStack<>();
        IDictionary<String, Integer> dict1 = new Dictionary<>();
        IList<Integer> l1 = new outputList<>();
        stack1.push(ex4);
        PrgState p = new PrgState(stack1, dict1, l1, new FileTable<>(), new Heap<>(), 4, ex4, lockTable, new CyclicBarrier<>(), latchTable);
        return p;
    }

    private PrgState prg5()
    {
        // v=6;
        // (while (v!=4) print(v);v=v-1);
        // print(v)

        Statement ex5 = new CompStmt(
                new CompStmt(
                        new AssignStmt("v", new ConstExpr(6)),
                        new WhileStmt(
                                new DifferentExpr(
                                        new VarExpr("v"),
                                        new ConstExpr(4)),
                                new CompStmt(
                                        new PrintStmt(new VarExpr("v")),
                                        new AssignStmt("v",
                                                new ArithmeticExpr('-',
                                                        new VarExpr("v"),
                                                        new ConstExpr(1)))
                                )
                        )
                ),
                new PrintStmt(new VarExpr("v"))
        );

        ILatchTable<Integer,Integer> latchTable = new LatchTable<>();
        ILockTable<Integer, Integer> lockTable = new LockTable<>();
        IExecStack<Statement> stack1 = new ExeStack<>();
        IDictionary<String, Integer> dict1 = new Dictionary<>();
        IList<Integer> l1 = new outputList<>();
        stack1.push(ex5);
        PrgState p = new PrgState(stack1, dict1, l1, new FileTable<>(), new Heap<>(), 5, ex5, lockTable,new CyclicBarrier<>(), latchTable);
        return p;
    }

    private PrgState prg6()
    {
        // x = 10 + (2<6) it should evaluate the statement to 11

        Statement ex6 = new AssignStmt("x",
                new ArithmeticExpr('+',
                        new ConstExpr(10),
                        new LessExpr(
                                new ConstExpr(2),
                                new ConstExpr(6))));

        ILatchTable<Integer,Integer> latchTable = new LatchTable<>();
        ILockTable<Integer, Integer> lockTable = new LockTable<>();
        IExecStack<Statement> stack1 = new ExeStack<>();
        IDictionary<String, Integer> dict1 = new Dictionary<>();
        IList<Integer> l1 = new outputList<>();
        stack1.push(ex6);
        PrgState p = new PrgState(stack1, dict1, l1, new FileTable<>(), new Heap<>(), 6, ex6, lockTable, new CyclicBarrier<>(), latchTable);
        return p;
    }

    private PrgState prg7()
    {
        //v=10;
        //newH(a,22);
        //fork(wH(a,30);v=32;print(v);print(rH(a)));
        //print(v);
        //print(rH(a))

        Statement ex7 = new CompStmt(new AssignStmt("v",new ConstExpr(10)),
                                    new CompStmt(new NewHeap("a",new ConstExpr(22)),
                                                 new CompStmt(new ForkStmt(new CompStmt(new WriteHeap("a",new ConstExpr(30)),
                                                                                        new CompStmt(new AssignStmt("v",new ConstExpr(32)),
                                                                                                     new CompStmt(new PrintStmt(new VarExpr("v")),
                                                                                                                  new PrintStmt(new ReadHeap("a")))))),
                                                              new CompStmt(new PrintStmt(new VarExpr("v")),
                                                                           new PrintStmt(new ReadHeap("a"))))));

        ILatchTable<Integer,Integer> latchTable = new LatchTable<>();
        ILockTable<Integer, Integer> lockTable = new LockTable<>();
        IExecStack<Statement> stack1 = new ExeStack<>();
        IDictionary<String, Integer> dict1 = new Dictionary<>();
        IList<Integer> l1 = new outputList<>();
        stack1.push(ex7);
        PrgState p = new PrgState(stack1, dict1, l1, new FileTable<>(), new Heap<>(), 7, ex7, lockTable, new CyclicBarrier<>(), latchTable);
        return p;
    }

    private PrgState prg8()
    {
        //v=20;
        //(for(v=0;v<3;v=v+1) fork(print(v);v=v+1) );
        //print(v*10)
        Statement ex8 = new CompStmt(new CompStmt(new AssignStmt("v", new ConstExpr(20)),
                                                  new ForStmt(new VarExpr("v"),
                                                            new ConstExpr(0),
                                                            new ConstExpr(3),
                                                            new ArithmeticExpr('+', new VarExpr("v"), new ConstExpr(1)),
                                                            new ForkStmt(new CompStmt(new PrintStmt(new VarExpr("v")),
                                                                                      new AssignStmt("v",
                                                                                                    new ArithmeticExpr('+',
                                                                                                            new VarExpr("v"),
                                                                                                            new ConstExpr(1))))))),
                                    new PrintStmt(new ArithmeticExpr('*',
                                                                    new VarExpr("v"),
                                                                    new ConstExpr(10))));

        ILatchTable<Integer,Integer> latchTable = new LatchTable<>();
        ILockTable<Integer, Integer> lockTable = new LockTable<>();
        IExecStack<Statement> stack1 = new ExeStack<>();
        IDictionary<String, Integer> dict1 = new Dictionary<>();
        IList<Integer> l1 = new outputList<>();
        stack1.push(ex8);
        PrgState p = new PrgState(stack1, dict1, l1, new FileTable<>(), new Heap<>(), 8, ex8, lockTable, new CyclicBarrier<>(), latchTable);
        return p;
    }

    private PrgState prg9()
    {
       /* new(v1,20);new(v2,30);newLock(x);
        fork(
                fork(
                        lock(x);wh(v1,rh(v1)-1);unlock(x)
            );
        lock(x);wh(v1,rh(v1)+1);unlock(x)
        );newLock(q);
        fork(
               fork(lock(q);wh(v2,rh(v2)+5);unlock(q));
        m=100;lock(q);wh(v2,rh(v2)+1);unlock(q)
           );
        z=200;z=300;z=400;
        lock(x);
        print (rh(v1));
        unlock(x);
        lock(q);
        print(rh(v2));
        unlock(q) */

        Statement ex9 = new CompStmt(new CompStmt(new CompStmt(new CompStmt(new CompStmt(new CompStmt(new CompStmt(new CompStmt(new CompStmt(
                                                                                                                                    new NewHeap("v1", new ConstExpr(20)),
                                                                                                                                    new NewHeap("v2", new ConstExpr(30))),
                                                                                                                              new NewLockStmt("x")),
                                                                                                                 new ForkStmt(new CompStmt(new ForkStmt(new CompStmt(new LockTableStmt("x"),
                                                                                                                                                                     new WriteHeap("v1",
                                                                                                                                                                                    new ArithmeticExpr('-',
                                                                                                                                                                                            new ReadHeap("v1"),
                                                                                                                                                                                            new ConstExpr(1))))),
                                                                                                                                            new UnlockTableStmt("x"))
                                                                                                                            )
                                                                                                                    ),
                                                                                                    new CompStmt(new CompStmt(new LockTableStmt("x"),
                                                                                                                                new WriteHeap("v1",
                                                                                                                                        new ArithmeticExpr('+',
                                                                                                                                                new ReadHeap("v1"),
                                                                                                                                                new ConstExpr(1)))),
                                                                                                                 new UnlockTableStmt("x"))),
                                                                                             new CompStmt(new NewLockStmt("q"),
                                                                                                          new ForkStmt(new CompStmt(new ForkStmt(new CompStmt(new LockTableStmt("q"),
                                                                                                                                                              new WriteHeap("v2", new ArithmeticExpr('+',
                                                                                                                                                                                                         new ReadHeap("v2"),
                                                                                                                                                                                                         new ConstExpr(5))))),
                                                                                                                                    new UnlockTableStmt("q"))))),
                                                                        new CompStmt(new CompStmt(new AssignStmt("m", new ConstExpr(100)),
                                                                                                    new WriteHeap("v2", new ArithmeticExpr('+',
                                                                                                            new ReadHeap("v2"),
                                                                                                            new ConstExpr(1)))),
                                                                                    new UnlockTableStmt("q"))),
                                                                new CompStmt(new CompStmt(new CompStmt(new AssignStmt("z", new ConstExpr(200)),
                                                                                                        new AssignStmt("z", new ConstExpr(300))),
                                                                                            new AssignStmt("z", new ConstExpr(400))),
                                                                            new CompStmt(new CompStmt(new LockTableStmt("x"),
                                                                                                        new PrintStmt(new ReadHeap("v1"))),
                                                                                        new CompStmt(new UnlockTableStmt("x"),
                                                                                                    new LockTableStmt("q"))))),
                                                    new PrintStmt(new ReadHeap("v2"))),
                                         new UnlockTableStmt("q"));

        ILatchTable<Integer,Integer> latchTable = new LatchTable<>();
        ILockTable<Integer, Integer> lockTable = new LockTable<>();
        IExecStack<Statement> stack1 = new ExeStack<>();
        IDictionary<String, Integer> dict1 = new Dictionary<>();
        IList<Integer> l1 = new outputList<>();
        stack1.push(ex9);
        PrgState p = new PrgState(stack1, dict1, l1, new FileTable<>(), new Heap<>(), 9, ex9, lockTable, new CyclicBarrier<>(), latchTable);
        return p;
    }


    private PrgState prg10()
    {
        //v=0;
        //(while(v<3) (fork(print(v);v=v+1);v=v+1);
        //sleep(15);
        //print(v*10)
        Statement ex10 = new CompStmt(new AssignStmt("v",new ConstExpr(0)),
                                      new CompStmt(new WhileStmt(new LessExpr(new VarExpr("v"),
                                                                              new ConstExpr(3)),
                                                                 new CompStmt(new ForkStmt(new CompStmt(new PrintStmt(new VarExpr("v")),
                                                                                                        new AssignStmt("v",new ArithmeticExpr('+',
                                                                                                                                            new VarExpr("v"),
                                                                                                                                            new ConstExpr(1))))),
                                                                              new AssignStmt("v",
                                                                                                new ArithmeticExpr('+',
                                                                                                                    new VarExpr("v"),
                                                                                                                    new ConstExpr(1))))),
                                                    new CompStmt(new SleepStmt(new ConstExpr(15)),
                                                                new PrintStmt(new ArithmeticExpr('*',
                                                                                                    new VarExpr("v"),
                                                                                                    new ConstExpr(10))))));

        ILatchTable<Integer,Integer> latchTable = new LatchTable<>();
        ILockTable<Integer, Integer> lockTable = new LockTable<>();
        IExecStack<Statement> stack1 = new ExeStack<>();
        IDictionary<String, Integer> dict1 = new Dictionary<>();
        IList<Integer> l1 = new outputList<>();
        stack1.push(ex10);
        PrgState p = new PrgState(stack1, dict1, l1, new FileTable<>(), new Heap<>(), 10, ex10, lockTable, new CyclicBarrier<>(), latchTable);
        return p;
    }

    public PrgState prg11()
    {
        //v=0;
        //(repeat (fork(print(v);v=v-1);v=v+1) until v==3);
        //x=1;y=2;z=3;w=4;
        //print(v*10)

        Statement ex11 = new CompStmt(new CompStmt(new AssignStmt("v", new ConstExpr(0)),
                new RepeatStmt(new CompStmt(new ForkStmt(new CompStmt(new PrintStmt(new VarExpr("v")),
                        new AssignStmt("v",new ArithmeticExpr('+',new VarExpr("v"),new ConstExpr(1))))),
                        new AssignStmt("v",new ArithmeticExpr('+',new VarExpr("v"),new ConstExpr(1)))),
                        new EqualExpr(new VarExpr("v"),new ConstExpr(3)))),
                new CompStmt(new CompStmt(new CompStmt(new AssignStmt("x", new ConstExpr(1)),
                        new AssignStmt("y", new ConstExpr(2))),
                        new CompStmt(new AssignStmt("x", new ConstExpr(3)),
                                new AssignStmt("w", new ConstExpr(4)))),
                        new PrintStmt(new ArithmeticExpr('*',
                                new VarExpr("v"),
                                new ConstExpr(10)))));

        ILatchTable<Integer,Integer> latchTable = new LatchTable<>();
        ILockTable<Integer, Integer> lockTable = new LockTable<>();
        IExecStack<Statement> stack1 = new ExeStack<>();
        IDictionary<String, Integer> dict1 = new Dictionary<>();
        IList<Integer> l1 = new outputList<>();
        stack1.push(ex11);
        PrgState p = new PrgState(stack1, dict1, l1, new FileTable<>(), new Heap<>(), 11, ex11, lockTable, new CyclicBarrier<>(), latchTable);
        return p;
    }

    public PrgState prg12()
    {
        Statement h1= new NewHeap("v1",new ConstExpr(2));
        Statement h2= new NewHeap("v2",new ConstExpr(3));
        Statement h3= new NewHeap("v3",new ConstExpr(4));
        Expression e=new ReadHeap("v3");
        Statement line1=new CompStmt(h1,new CompStmt(h2,new CompStmt(h3,new NewBarrierStmt("cnt",e))));
        Statement fork1=new ForkStmt((new CompStmt(new WriteHeap("v1",(new ArithmeticExpr('*',new ReadHeap("v1"),new ConstExpr(10)))),
                new CompStmt(new PrintStmt(new ReadHeap("v1")), new AwaitStmt("cnt")))));
        Statement fork2=new ForkStmt((new CompStmt(new AwaitStmt("cnt"),new CompStmt(new WriteHeap("v2",(new ArithmeticExpr('*',new ReadHeap("v2"),new ConstExpr(10)))),
                new PrintStmt(new ReadHeap("v2"))))));
        Statement fork3=new ForkStmt((new CompStmt(new AwaitStmt("cnt"),new CompStmt(new WriteHeap("v3",(new ArithmeticExpr('*',new ReadHeap("v3"),new ConstExpr(10)))),
                new CompStmt(new WriteHeap("v3",(new ArithmeticExpr('*',new ReadHeap("v3"),new ConstExpr(10)))),new PrintStmt(new ReadHeap("v3")))))));
        Statement right=new CompStmt(new AwaitStmt("cnt"),new PrintStmt(new ConstExpr(2000)));
        Statement ex12=new CompStmt(line1,new CompStmt(fork1,new CompStmt(fork2,new CompStmt(fork3,right))));

        ILatchTable<Integer,Integer> latchTable = new LatchTable<>();
        ILockTable<Integer, Integer> lockTable = new LockTable<>();
        IExecStack<Statement> stack1 = new ExeStack<>();
        IDictionary<String, Integer> dict1 = new Dictionary<>();
        IList<Integer> l1 = new outputList<>();
        stack1.push(ex12);
        PrgState p = new PrgState(stack1, dict1, l1, new FileTable<>(), new Heap<>(), 12, ex12, lockTable, new CyclicBarrier<>(), latchTable);
        return p;
    }
}