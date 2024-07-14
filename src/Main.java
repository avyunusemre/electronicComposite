import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Connector c1 = new Connector();
        Connector c2 = new Connector();
        Connector c3 = new Connector();

        ElectronicComposite p1 = new ElectronicComposite.EeBuilder("Parent1", "longParent1")
                .build();

        ElectronicComposite p2 = new ElectronicComposite.EeBuilder("Parent2", "longParent2")
                .setEeLogicalConnectors(List.of(c1, c3))
                .build();

        ElectronicComposite p3 = new ElectronicComposite.EeBuilder("Parent3", "longParent3")
                .setShortName("pr3")
                .build();

        ElectronicComposite e1 = new ElectronicComposite.EeBuilder("Example1", "longExample1")
                .setParentEe(p1)
                .setShortName("ex1")
                .setEeLogicalConnectors(List.of(c1, c2))
                .build();
        ElectronicComposite e2 = new ElectronicComposite.EeBuilder("Example2", "longExample2")
                .setParentEe(p1)
                .setShortName("ex2")
                .setEeLogicalConnectors(List.of(c1, c2))
                .build();
        ElectronicComposite e3 = new ElectronicComposite.EeBuilder("Example3", "longExample3")
                .setParentEe(p1)
                .setShortName("ex3")
                .setEeLogicalConnectors(List.of(c1))
                .build();
        ElectronicComposite e4 = new ElectronicComposite.EeBuilder("Example4", "longExample4")
                .setParentEe(p1)
                .setEeLogicalConnectors(List.of(c1, c2, c3))
                .build();

        ElectronicComposite e5 = new ElectronicComposite.EeBuilder("Example5", "longExample5")
                .setParentEe(p2)
                .build();

        ElectronicComposite e6 = new ElectronicComposite.EeBuilder("Example6", "longExample6")
                .setParentEe(p2)
                .setEeLogicalConnectors(List.of(c1, c2, c3))
                .setShortName("ex6")
                .build();

        ElectronicComposite e7 = new ElectronicComposite.EeBuilder("Example7", "longExample7")
                .setParentEe(p3)
                .setEeLogicalConnectors(List.of(c1, c2, c3))
                .setShortName("ex7")
                .build();

        ElectronicComposite e8 = new ElectronicComposite.EeBuilder("Example8", "longExample8")
                .setParentEe(e7)
                .setEeLogicalConnectors(List.of(c1, c2, c3))
                .setShortName("ex8")
                .build();

        p1.addChildElements(List.of(e1, e2, e3, e4));
        p2.addChildElements(List.of(e5, e6));
        p3.addChildElements(List.of(e7));
        e7.addChildElements(List.of(e8));

        List<ElectronicComposite> electronicComposites = List.of(e1, e2, e3, e4, e5, e6, e8);

        printInfos(setResult(electronicComposites));

    }


    public static Set<ElectronicComposite> setResult(List<ElectronicComposite> electronicComposites) {
        Set<ElectronicComposite> electronicCompositeSet = new HashSet<>();
        for (ElectronicComposite e : electronicComposites) {
            electronicCompositeSet.add(e);
            if (e.hasParent()) {
                electronicCompositeSet.add(e.getParentEE());
            }
            if (e.hasChildren()) {
                setResult(e.getChildEEs());
            }
        }

        return electronicCompositeSet;
    }

    public static void printInfos(Set<ElectronicComposite> electronicComposites) {
        for (ElectronicComposite e : electronicComposites) {
            System.out.printf("""
                        Name: %s, Has Children : %b, Parent Name: %s, Amount of Connector : %d,  Long Name : %s, Short Name : %s
                        """,
                    e.getName(), e.hasChildren(),
                    e.getParentName(), e.amountOfCollectors(),
                    e.getLongName(), e.getShortName());
        }

    }
}