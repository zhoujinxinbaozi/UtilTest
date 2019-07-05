package clone;

public class Entity implements Cloneable{
    private String entity;

    public Entity(String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }

        if(obj instanceof Entity){
            Entity en = (Entity)obj;
            return en.getEntity().equals(this.getEntity());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (this.getEntity() == null) ? 0: this.getEntity().hashCode();
        return result;
    }
}
