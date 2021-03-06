/**
 * Copyright (C) 2017 Red Hat, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.syndesis.example;

import io.syndesis.connector.daytrade.Trade;
import io.syndesis.connector.tradeinsight.Suggestion;

public class TradeDataMapper {

    public Trade mapToTrade(Suggestion suggestion) {
        Trade trade = new Trade();
        trade.setAction(suggestion.getOrder().split(" ")[0]);
        trade.setTicker(suggestion.getOrder().split(" ")[1]);
        trade.setQuantity(suggestion.getDetail().getNumShares());
        trade.setLimit(suggestion.getDetail().getTargetPrice());
        trade.setExpiration(suggestion.getContext().getTradeWindowEnd());
        return trade;
    }

}
