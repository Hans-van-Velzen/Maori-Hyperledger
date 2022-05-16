package nz.maori.wakadistrict.landcourt.ledgerapi;


@FunctionalInterface
public interface StateDeserializer {
    State deserialize(byte[] buffer);
}