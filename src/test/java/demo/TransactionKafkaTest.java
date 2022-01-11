package demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import demo.kafka.TransactionKafkaReciever;
import demo.kafka.TransactionKafkaSender;

@SpringBootTest
@DirtiesContext
@TestPropertySource("/application-test.properties")
//@EmbeddedKafka(partitions = 1, //
//		brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
public class TransactionKafkaTest {

	private CountDownLatch latch = new CountDownLatch(1);

	@Autowired
	private TransactionKafkaSender sender;

	@SpyBean
	private TransactionKafkaReciever receiver;

	@Test
	public void test() throws Exception {
		sender.send("Test Message");
		latch.await(10000, TimeUnit.MILLISECONDS);
		Mockito.verify(receiver, Mockito.atLeastOnce()).createTransaction(Mockito.any());
	}
}