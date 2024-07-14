import java.util.List;

public class ElectronicComposite {

    private final String name;

    private final List<ElectronicComposite> childEEs;

    private final List<Connector> eeLogicalConnectors;

    private final String shortName;

    private final String longName;

    private final ElectronicComposite parentEe;

    public static class EeBuilder {

        //required parameters
        private final String name;
        private final String longName;

        //optional parameters
        List<ElectronicComposite> childElements;
        List<Connector> eeLogicalConnectors;
        String shortName;
        ElectronicComposite parentEe;

        public EeBuilder(ElectronicComposite oldObject) {
            this.name = oldObject.name;
            this.longName = oldObject.longName;
            this.parentEe = oldObject.parentEe;
            this.shortName = oldObject.shortName;
            this.childElements = oldObject.childEEs;
            this.eeLogicalConnectors = oldObject.eeLogicalConnectors;
        }

        public EeBuilder(String name, String longName) {
            this.name = name;
            this.longName = longName;
        }

        public EeBuilder setChildElements(List<ElectronicComposite> childElements) {
            this.childElements = childElements;
            return this;
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

    public ElectronicComposite(EeBuilder builder) {
        this.name = builder.name;
        this.childEEs = builder.childElements;
        this.eeLogicalConnectors = builder.eeLogicalConnectors;
        this.shortName = builder.shortName;
        this.longName = builder.longName;
        this.parentEe = builder.parentEe;
    }

}

