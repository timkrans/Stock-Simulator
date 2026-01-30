# Stock-Simulator
- This is a stock simulator that will right not has three endpoints one for adding a stock ticker one for generating prices and one for generating a box and wisker points from those prices

## What does it do
- currently it is just randomlying changinging the prices. And generating a box and wisker points from that

## Example calls
```bash
curl -X POST "http://localhost:8080/api/market/generate/AAPL?ticks=500"
curl "http://localhost:8080/api/market/box/AAPL"                       
curl "http://localhost:8080/api/market/prices/AAPL"
```                    

## Future enhancements
- Adding different strategy bots to show actual movement instead of random movement
- Adding a frontend to place the box and wisker every 1 min on a graph
- After the bots seem reasonable and normal stock movements training a AI to try to beat the bots