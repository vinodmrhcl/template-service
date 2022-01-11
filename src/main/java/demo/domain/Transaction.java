package demo.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private Long customerId;
	private Long accountId;
	
	private Double amount;

	private Date txnTime;

}
