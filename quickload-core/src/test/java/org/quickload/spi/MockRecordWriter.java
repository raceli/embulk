package org.quickload.spi;

import java.util.concurrent.atomic.AtomicInteger;

import org.quickload.record.BooleanWriter;
import org.quickload.record.Column;
import org.quickload.record.DoubleWriter;
import org.quickload.record.LongWriter;
import org.quickload.record.RecordWriter;
import org.quickload.record.StringWriter;
import org.quickload.record.TimestampWriter;
import org.quickload.time.Timestamp;

public class MockRecordWriter implements RecordWriter
{
    private static final boolean[] BOOLEAN = new boolean[] { true, false };
    private static final long[] LONG = new long[] { 1, 2, 3 };
    private static final double[] DOUBLE = new double[] { 1.0D, 2.0D, 3.0D,
            4.0D };
    private static final String[] STRING = new String[] { "a", "b", "c", "d",
            "e" };
    private static final Timestamp[] TIMESTAMP = new Timestamp[] {
            Timestamp.ofEpochSecond(0), Timestamp.ofEpochSecond(1),
            Timestamp.ofEpochSecond(2), Timestamp.ofEpochSecond(3),
            Timestamp.ofEpochSecond(4), Timestamp.ofEpochSecond(5) };

    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void writeBoolean(Column column, BooleanWriter writer)
    {
        writer.write(BOOLEAN[(column.getIndex() + counter.getAndIncrement())
                % BOOLEAN.length]);
    }

    @Override
    public void writeLong(Column column, LongWriter writer)
    {
        writer.write(LONG[(column.getIndex() + counter.getAndIncrement())
                % LONG.length]);
    }

    @Override
    public void writeDouble(Column column, DoubleWriter writer)
    {
        writer.write(DOUBLE[(column.getIndex() + counter.getAndIncrement())
                % DOUBLE.length]);
    }

    @Override
    public void writeString(Column column, StringWriter writer)
    {
        writer.write(STRING[(column.getIndex() + counter.getAndIncrement())
                % STRING.length]);
    }

    @Override
    public void writeTimestamp(Column column, TimestampWriter writer)
    {
        writer.write(TIMESTAMP[(column.getIndex() + counter.getAndIncrement())
                % TIMESTAMP.length]);
    }
}
