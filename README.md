The logs files could be find in: /log. Are jsonl based.

Labs:
- 01 Ingest jsonl to events.

## Log Event Schema

Each line represents **one log event** (JSON Lines format).

### Core
- `ts` — ISO-8601 UTC timestamp
- `level` — `DEBUG | INFO | WARN | ERROR`
- `message` — stable event identifier (e.g. `request.ok`)

### Context
- `service` — emitting service name
- `env` — deployment environment (`prod`, `staging`)
- `host` — node/instance identifier

### Tracing
- `traceId` — request identifier (cross-service)
- `spanId` — current execution span
- `parentSpanId` — parent span (trace reconstruction)

### Request
- `method` — HTTP method
- `path` — resolved request path
- `status` — HTTP status code
- `durationMs` — latency in milliseconds

### Client
- `userId` — user identifier
- `country` — ISO country code
- `userAgent` — client user agent

### Classification
- `tags` — event labels (`http`, `error`, `incident`, …)

### Error (optional)
- `error.type` — exception class
- `error.code` — domain error code
- `error.stack` — structured stack trace frames


Example: 
```json
{
  "ts":"2026-02-04T08:12:40.531Z",
  "env":"prod",
  "service":"orders-service",
  "host":"node-b",
  "level":"ERROR",
  "traceId":"9c2f...e1a0",
  "spanId":"7b1a...33f2",
  "parentSpanId":null,
  "method":"POST",
  "path":"/orders",
  "status":503,
  "durationMs":1420,
  "userId":"u1558",
  "country":"ES",
  "userAgent":"Mozilla/5.0",
  "tags":["http","error","incident","orders"],
  "message":"downstream.timeout",
  "error":{
    "type":"TimeoutException",
    "code":"ORD-TOUT",
    "stack":[
      "orders.OrderController.create(OrderController.java:88)",
      "orders.OrderService.placeOrder(OrderService.java:211)",
      "http.Client.call(Client.java:55)"
    ]
  }
}

```