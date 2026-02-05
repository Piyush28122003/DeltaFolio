package com.delta.Deltafolio.util;


import com.delta.Deltafolio.model.Investment;
import com.delta.Deltafolio.model.RiskProfile;
import com.delta.Deltafolio.model.Stock;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RecommendationEngine {
    
    /**
     * Generate stock recommendations to buy based on user's risk profile and current portfolio
     */
    public static List<String> recommendStocksToBuy(
            RiskProfile riskProfile,
            List<Investment> currentInvestments,
            List<Stock> availableStocks) {
        
        List<String> recommendations = new ArrayList<>();
        
        if (riskProfile == null || currentInvestments == null || availableStocks == null) {
            return recommendations;
        }
        
        // Get current sectors in portfolio
        Set<String> currentSectors = currentInvestments.stream()
            .map(inv -> inv.getStock().getSector())
            .filter(sector -> sector != null)
            .collect(Collectors.toSet());
        
        // Get current stock symbols
        Set<String> currentSymbols = currentInvestments.stream()
            .map(inv -> inv.getStock().getSymbol())
            .collect(Collectors.toSet());
        
        // Filter available stocks (not already owned)
        List<Stock> candidateStocks = availableStocks.stream()
            .filter(stock -> !currentSymbols.contains(stock.getSymbol()))
            .collect(Collectors.toList());
        
        // Generate recommendations based on risk profile
        switch (riskProfile.getRiskCategory()) {
            case CONSERVATIVE:
                // Recommend stable, dividend-paying stocks
                recommendations.add("Consider adding: JNJ (Healthcare - Stable), PG (Consumer Defensive - Reliable)");
                recommendations.add("Focus on sectors: Healthcare, Consumer Defensive, Utilities");
                break;
                
            case MODERATE:
                // Recommend balanced mix
                recommendations.add("Consider adding: MSFT (Technology - Growth), JPM (Financial Services - Stability)");
                recommendations.add("Diversify into: Technology, Financial Services, Healthcare");
                break;
                
            case AGGRESSIVE:
                // Recommend high-growth stocks
                recommendations.add("Consider adding: NVDA (Technology - High Growth), TSLA (Consumer Cyclical - Innovation)");
                recommendations.add("Focus on: Technology, Consumer Cyclical, Emerging Markets");
                break;
        }
        
        // Add diversification recommendations
        if (currentSectors.size() < 3) {
            recommendations.add("💡 Diversification Tip: Your portfolio has limited sector diversity. Consider adding stocks from different sectors.");
        }
        
        return recommendations;
    }
    
    /**
     * Generate stock recommendations to sell based on portfolio analysis
     */
    public static List<String> recommendStocksToSell(
            RiskProfile riskProfile,
            List<Investment> investments,
            BigDecimal currentPrice,
            BigDecimal buyPrice) {
        
        List<String> recommendations = new ArrayList<>();
        
        if (investments == null || investments.isEmpty()) {
            return recommendations;
        }
        
        // Analyze each investment
        for (Investment investment : investments) {
            BigDecimal profitLossPercent = calculateProfitLossPercentage(
                investment.getBuyPrice(), 
                currentPrice
            );
            
            // Recommend selling if significant loss and risk-averse
            if (riskProfile.getRiskCategory() == RiskProfile.RiskCategory.CONSERVATIVE) {
                if (profitLossPercent.compareTo(new BigDecimal("-10.0")) < 0) {
                    recommendations.add(String.format(
                        "⚠️ Consider selling %s: Down %.2f%%. May not align with conservative strategy.",
                        investment.getStock().getSymbol(),
                        profitLossPercent
                    ));
                }
            }
            
            // Recommend taking profits if significant gain
            if (profitLossPercent.compareTo(new BigDecimal("30.0")) > 0) {
                recommendations.add(String.format(
                    "💰 Consider taking profits on %s: Up %.2f%%. Lock in gains.",
                    investment.getStock().getSymbol(),
                    profitLossPercent
                ));
            }
        }
        
        if (recommendations.isEmpty()) {
            recommendations.add("✅ Your portfolio looks balanced. No immediate sell recommendations.");
        }
        
        return recommendations;
    }
    
    /**
     * Calculate profit/loss percentage
     */
    private static BigDecimal calculateProfitLossPercentage(BigDecimal buyPrice, BigDecimal currentPrice) {
        if (buyPrice == null || currentPrice == null || buyPrice.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        
        return currentPrice.subtract(buyPrice)
            .divide(buyPrice, 4, RoundingMode.HALF_UP)
            .multiply(BigDecimal.valueOf(100))
            .setScale(2, RoundingMode.HALF_UP);
    }
    
    /**
     * Generate general investment advice based on risk profile
     */
    public static String generateInvestmentAdvice(RiskProfile riskProfile) {
        if (riskProfile == null) {
            return "Please complete your risk profile assessment to receive personalized advice.";
        }
        
        return switch (riskProfile.getRiskCategory()) {
            case CONSERVATIVE -> 
                "📊 Conservative Strategy:\n" +
                "• Focus on blue-chip stocks and dividend-paying companies\n" +
                "• Maintain 20-30% cash reserves\n" +
                "• Consider bonds for stability\n" +
                "• Rebalance quarterly";
                
            case MODERATE -> 
                "📊 Moderate Strategy:\n" +
                "• Balanced mix of growth and value stocks\n" +
                "• Maintain 10-20% cash reserves\n" +
                "• Diversify across 5-7 sectors\n" +
                "• Rebalance semi-annually";
                
            case AGGRESSIVE -> 
                "📊 Aggressive Strategy:\n" +
                "• Focus on high-growth technology and innovation stocks\n" +
                "• Maintain 5-10% cash reserves\n" +
                "• Accept higher volatility for potential returns\n" +
                "• Monitor and rebalance monthly";
        };
    }
}

