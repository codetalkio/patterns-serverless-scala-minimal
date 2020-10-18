## Response Times

The following are the response time results from AWS XRay, generated after running `npm run benchmark`.

| Response time | Initialization | Invocation | Overhead | Cold Start | Warm Start |
|---------------|----------------|------------|----------|------------|------------|
| 306.9 ms | 2.4 ms | 1.8 ms | 0.2 ms | 🥶 |  |
| 40.9 ms |  | 15.8 ms | 18.6 ms |  | 🥵 |
| 16 ms |  | 1.6 ms | 0.3 ms |  | 🥵 |
| 19 ms |  | 8.4 ms | 0.3 ms |  | 🥵 |
| 9.9 ms |  | 1.7 ms | 0.1 ms |  | 🥵 |
| 10.9 ms |  | 1.7 ms | 0.2 ms |  | 🥵 |
| 19.9 ms |  | 11.8 ms | 0.2 ms |  | 🥵 |
| 9.9 ms |  | 1.6 ms | 0.1 ms |  | 🥵 |
| 10.9 ms |  | 1.8 ms | 0.2 ms |  | 🥵 |
| 11 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 9.9 ms |  | 1.7 ms | 0.3 ms |  | 🥵 |
| 11 ms |  | 1.8 ms | 0.2 ms |  | 🥵 |
| 9.9 ms |  | 1.7 ms | 0.3 ms |  | 🥵 |
| 9.9 ms |  | 1.8 ms | 0.2 ms |  | 🥵 |
| 302 ms | 2.3 ms | 1.9 ms | 0.2 ms | 🥶 |  |
| 9.9 ms |  | 1.8 ms | 0.2 ms |  | 🥵 |
| 315 ms | 2 ms | 2 ms | 0.1 ms | 🥶 |  |
| 10 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 10.9 ms |  | 1.8 ms | 0.2 ms |  | 🥵 |
| 9.9 ms |  | 1.9 ms | 0.2 ms |  | 🥵 |
| 10 ms |  | 1.9 ms | 0.2 ms |  | 🥵 |
| 319 ms | 2.2 ms | 2 ms | 1.3 ms | 🥶 |  |
| 12 ms |  | 1.9 ms | 0.2 ms |  | 🥵 |
| 302 ms | 1.9 ms | 1.9 ms | 0.3 ms | 🥶 |  |
| 11 ms |  | 1.7 ms | 0.2 ms |  | 🥵 |
| 36 ms |  | 27.1 ms | 0.3 ms |  | 🥵 |
| 76.9 ms |  | 59.6 ms | 0.2 ms |  | 🥵 |
| 297 ms | 2.8 ms | 2.4 ms | 8.6 ms | 🥶 |  |
| 77 ms |  | 41.5 ms | 18.5 ms |  | 🥵 |
| 9 ms |  | 1.8 ms | 0.2 ms |  | 🥵 |
| 15 ms |  | 8.1 ms | 0.2 ms |  | 🥵 |
| 10.9 ms |  | 1.9 ms | 0.2 ms |  | 🥵 |
| 303.9 ms | 2.5 ms | 9.9 ms | 0.4 ms | 🥶 |  |
| 47 ms |  | 19.7 ms | 18.9 ms |  | 🥵 |
| 10.9 ms |  | 1.7 ms | 0.2 ms |  | 🥵 |
| 287 ms | 2.2 ms | 2 ms | 0.2 ms | 🥶 |  |
| 9.9 ms |  | 1.9 ms | 0.2 ms |  | 🥵 |
| 276 ms | 1.9 ms | 2 ms | 0.3 ms | 🥶 |  |
| 10.9 ms |  | 2 ms | 0.5 ms |  | 🥵 |
| 49 ms |  | 21.2 ms | 19.7 ms |  | 🥵 |
| 18 ms |  | 9.4 ms | 0.3 ms |  | 🥵 |
| 319.9 ms | 2.4 ms | 14.8 ms | 0.4 ms | 🥶 |  |
| 8.9 ms |  | 1.7 ms | 0.2 ms |  | 🥵 |
| 41 ms |  | 27.7 ms | 0.2 ms |  | 🥵 |
| 19 ms |  | 1.7 ms | 0.2 ms |  | 🥵 |
| 9.9 ms |  | 1.7 ms | 0.1 ms |  | 🥵 |
| 18.9 ms |  | 7.8 ms | 0.2 ms |  | 🥵 |
| 29.9 ms |  | 2 ms | 18.6 ms |  | 🥵 |
| 11 ms |  | 1.8 ms | 0.3 ms |  | 🥵 |
| 9 ms |  | 1.8 ms | 0.2 ms |  | 🥵 |
| 72 ms |  | 41.5 ms | 18.4 ms |  | 🥵 |
| 11 ms |  | 1.6 ms | 0.1 ms |  | 🥵 |
| 59.9 ms |  | 52.1 ms | 0.2 ms |  | 🥵 |
| 46.9 ms |  | 20.1 ms | 18.7 ms |  | 🥵 |
| 44 ms |  | 36.2 ms | 0.2 ms |  | 🥵 |

## XRay Example of a Cold Start

<img width="1476" alt="Screenshot 2020-10-07 at 23 01 40" src="https://user-images.githubusercontent.com/1189998/95387505-178a1d00-08f1-11eb-83a7-7bc32eee48e2.png">

## XRay Example of a Warm Start

<img width="1479" alt="Screenshot 2020-10-07 at 23 01 23" src="https://user-images.githubusercontent.com/1189998/95387509-1953e080-08f1-11eb-8d46-ac25efa235e4.png">
