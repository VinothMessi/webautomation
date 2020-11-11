package com.nextgen.webautomation.testcases;

import java.util.Map;
import java.util.stream.Collectors;

import com.nextgen.webautomation.base.TestBase;
import com.nextgen.webautomation.entiry.Payment;
import com.nextgen.webautomation.repository.PaymentRepository;
import com.nextgen.webautomation.stratergypatternapp.CreditCard;
import com.nextgen.webautomation.stratergypatternapp.NetBanking;
import com.nextgen.webautomation.stratergypatternapp.PaymentOptions;
import com.nextgen.webautomation.workflows.PaymentWorkFlow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import static org.assertj.core.api.Assertions.*;

public class PaymentScreenTesting extends TestBase {

	@Value("${payment.app}")
	private String paymentApp;

	@Value("${payment.app.title}")
	private String pageTitle;

	@Autowired
	private PaymentRepository repository;

	@Test(dataProvider = "PaymentTesting")
	public void paymentOptionsTest(PaymentOptions payOptions, Map<String, String> paymentDetails) {
		PaymentWorkFlow.paymentPage((p) -> {
			assertThat(p.goTo(this.paymentApp).waitTillPageLoads().getPageTitle())
					.matches(title -> title.equals(this.pageTitle));
			p.getUserInfo().enter(paymentDetails.get("firstName"), paymentDetails.get("lastName"),
					paymentDetails.get("mail"));
			p.setPaymentOptions(payOptions);
			p.getPaymentOptions().enterDetails(paymentDetails);
			p.getOrderInfo().placeOrder();
			System.out.println(p.getOrderInfo().getOrderNumber());
		}, myBrowser);
	}

	@DataProvider(name = "PaymentTesting")
	public Object[][] getData() {

		Map<Integer, String> firstName = this.repository.findAll().stream()
				.collect(Collectors.toMap(Payment::getId, Payment::getFirstName));
		Map<Integer, String> lastName = this.repository.findAll().stream()
				.collect(Collectors.toMap(Payment::getId, Payment::getLastName));
		Map<Integer, String> email = this.repository.findAll().stream()
				.collect(Collectors.toMap(Payment::getId, Payment::getEmail));

		Map<String, String> cc1 = Maps.newHashMap();
		cc1.put("firstName", firstName.get(1));
		cc1.put("lastName", lastName.get(1));
		cc1.put("mail", email.get(1));
		cc1.put("cc", this.repository.findAll().get(0).getCcBank());
		cc1.put("year", this.repository.findAll().get(0).getYearAccount());
		cc1.put("cvv", this.repository.findAll().get(0).getPin());

		Map<String, String> netBank = Maps.newHashMap();
		netBank.put("firstName", firstName.get(2));
		netBank.put("lastName", lastName.get(2));
		netBank.put("mail", email.get(2));
		netBank.put("bank", this.repository.findAll().get(1).getCcBank());
		netBank.put("accountNumber", this.repository.findAll().get(1).getYearAccount());
		netBank.put("atmPin", this.repository.findAll().get(1).getPin());

		Map<String, String> cc2 = Maps.newHashMap();
		cc2.put("firstName", firstName.get(3));
		cc2.put("lastName", lastName.get(3));
		cc2.put("mail", email.get(3));
		cc2.put("cc", this.repository.findAll().get(2).getCcBank());
		cc2.put("year", this.repository.findAll().get(2).getYearAccount());
		cc2.put("cvv", this.repository.findAll().get(2).getPin());

		return new Object[][] { { new CreditCard(), cc1 }, { new NetBanking(), netBank }, { new CreditCard(), cc2 } };
	}

}