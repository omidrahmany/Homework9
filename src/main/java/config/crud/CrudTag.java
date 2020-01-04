package config.crud;

import entities.Tag;

public class CrudTag extends CrudOperation<Tag,Long> {
    private static CrudTag crudTag;

    private CrudTag(){}

    public static CrudTag getInstance() {
        if (crudTag == null) {
            crudTag = new CrudTag();
        }
        return crudTag;
    }

    @Override
    protected Class<Tag> getEntityClass() {
        return Tag.class;
    }

}
