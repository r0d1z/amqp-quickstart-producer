package rodrigo.queiroz.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record Quote(String id, int price) {

    @Override
    public String toString() {
        return "Quote{" +
                "id='" + id + '\'' +
                ", price=" + price +
                '}';
    }
}
