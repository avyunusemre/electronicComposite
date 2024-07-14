import java.util.ArrayList;
import java.util.List;

public class ElectronicComposite implements Composite {

    private final String name;

    private List<ElectronicComposite> childEEs = new ArrayList<>();

    private final List<Connector> eeLogicalConnectors;

    private final String shortName;

    private final String longName;

    private final ElectronicComposite parentEe;


    @Override
    public void addChildElements(List<ElectronicComposite> elements) {
        childEEs.addAll(elements);
    }

    public static class EeBuilder {

        //required parameters
        private final String name;
        private final String longName;

        //optional parameters
        private List<Connector> eeLogicalConnectors;
        private String shortName;
        private ElectronicComposite parentEe;

        public EeBuilder(ElectronicComposite oldObject) {
            this.name = oldObject.name;
            this.longName = oldObject.longName;
            this.parentEe = oldObject.parentEe;
            this.shortName = oldObject.shortName;
            this.eeLogicalConnectors = oldObject.eeLogicalConnectors;
        }

        public EeBuilder(String name, String longName) {
            this.name = name;
            this.longName = longName;
        }


        public EeBuilder setEeLogicalConnectors(List<Connector> eeLogicalConnectors) {
            this.eeLogicalConnectors = eeLogicalConnectors;
            return this;
        }

        public EeBuilder setShortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public EeBuilder setParentEe(ElectronicComposite parentEe) {
            this.parentEe = parentEe;
            return this;
        }

        public ElectronicComposite build() {
            return new ElectronicComposite(this);
        }
    }

    public String getShortName() {
        return shortName;
    }

    public String getName() {
        return name;
    }

    public List<ElectronicComposite> getChildEEs() {
        return childEEs;
    }

    public List<Connector> getEeLogicalConnectors() {
        return eeLogicalConnectors;
    }

    public String getLongName() {
        return longName;
    }

    public ElectronicComposite getParentEE() {
        return parentEe;
    }

    public boolean hasChildren() {
        return childEEs != null && !childEEs.isEmpty();
    }

    public int amountOfCollectors() {
        return eeLogicalConnectors == null ? 0 : eeLogicalConnectors.size();
    }

    public String getParentName() {
        if (parentEe != null) {
            return parentEe.getName();
        }
        return "NO PARENT";
    }

    public boolean hasParent() {
        return parentEe != null;
    }

    public ElectronicComposite(EeBuilder builder) {
        this.name = builder.name;
        this.eeLogicalConnectors = builder.eeLogicalConnectors;
        this.shortName = builder.shortName;
        this.longName = builder.longName;
        this.parentEe = builder.parentEe;
    }

}

