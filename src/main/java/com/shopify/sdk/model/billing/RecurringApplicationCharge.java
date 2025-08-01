package com.shopify.sdk.model.billing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecurringApplicationCharge {
    
    private String id;
    private String name;
    private String status;
    private BigDecimal price;
    private String currencyCode;
    
    @JsonProperty("created_at")
    private Instant createdAt;
    
    @JsonProperty("updated_at")
    private Instant updatedAt;
    
    @JsonProperty("activated_on")
    private Instant activatedOn;
    
    @JsonProperty("cancelled_on")
    private Instant cancelledOn;
    
    @JsonProperty("trial_ends_on")
    private Instant trialEndsOn;
    
    @JsonProperty("trial_days")
    private Integer trialDays;
    
    @JsonProperty("capped_amount")
    private BigDecimal cappedAmount;
    
    @JsonProperty("terms")
    private String terms;
    
    @JsonProperty("return_url")
    private String returnUrl;
    
    @JsonProperty("confirmation_url")
    private String confirmationUrl;
    
    @JsonProperty("test")
    private Boolean test;
    
    @JsonProperty("decorated_return_url")
    private String decoratedReturnUrl;
    
    @JsonProperty("billing_on")
    private String billingOn;
    
    @JsonProperty("balance_used")
    private BigDecimal balanceUsed;
    
    @JsonProperty("balance_remaining")
    private BigDecimal balanceRemaining;
    
    @JsonProperty("risk_level")
    private Integer riskLevel;
    
    public boolean isActive() {
        return "active".equals(status);
    }
    
    public boolean isCancelled() {
        return "cancelled".equals(status);
    }
    
    public boolean isPending() {
        return "pending".equals(status);
    }
    
    public boolean isDeclined() {
        return "declined".equals(status);
    }
    
    public boolean isExpired() {
        return "expired".equals(status);
    }
    
    public boolean isFrozen() {
        return "frozen".equals(status);
    }
    
    public boolean hasTrialPeriod() {
        return trialDays != null && trialDays > 0;
    }
    
    public boolean isCapped() {
        return cappedAmount != null && cappedAmount.compareTo(BigDecimal.ZERO) > 0;
    }
    
    public boolean isTest() {
        return test != null && test;
    }
    
    public boolean hasUsageCharges() {
        return "usage".equals(billingOn);
    }
}