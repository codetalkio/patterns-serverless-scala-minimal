## Response Times

The following are the response time results from AWS XRay, generated after running `npm run benchmark`.

| Response time | Initialization | Invocation | Overhead | Cold Start | Warm Start |
|---------------|----------------|------------|----------|------------|------------|
| 91 ms |  | 43.3 ms | 39.9 ms |  | 🥵 |
| 42 ms |  | 32.9 ms | 0.4 ms |  | 🥵 |
| 8.9 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 88.9 ms |  | 41 ms | 40.3 ms |  | 🥵 |
| 46 ms |  | 19 ms | 18.6 ms |  | 🥵 |
| 9 ms |  | 1.8 ms | 0.2 ms |  | 🥵 |
| 89.9 ms |  | 80.2 ms | 0.2 ms |  | 🥵 |
| 12 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 9 ms |  | 1.8 ms | 0.1 ms |  | 🥵 |
| 320 ms | 2 ms | 1.6 ms | 0.1 ms | 🥶 |  |
| 9 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 9 ms |  | 1.6 ms | 0.1 ms |  | 🥵 |
| 9.9 ms |  | 1.7 ms | 0.2 ms |  | 🥵 |
| 9 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 9.9 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 7.9 ms |  | 1.6 ms | 0.1 ms |  | 🥵 |
| 9 ms |  | 1.7 ms | 0.2 ms |  | 🥵 |
| 373 ms | 1.9 ms | 2 ms | 11.8 ms | 🥶 |  |
| 13 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 11 ms |  | 1.9 ms | 0.2 ms |  | 🥵 |
| 12 ms |  | 4.7 ms | 0.2 ms |  | 🥵 |
| 305.9 ms | 1.9 ms | 1.7 ms | 0.1 ms | 🥶 |  |
| 407 ms | 2.1 ms | 2.1 ms | 16.8 ms | 🥶 |  |
| 9 ms |  | 1.7 ms | 0.1 ms |  | 🥵 |
| 13 ms |  | 1.8 ms | 0.2 ms |  | 🥵 |
| 366 ms | 2.7 ms | 1.9 ms | 0.3 ms | 🥶 |  |
| 8.9 ms |  | 1.7 ms | 0.3 ms |  | 🥵 |
| 9.9 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 19.9 ms |  | 8.7 ms | 0.2 ms |  | 🥵 |
| 11 ms |  | 1.9 ms | 0.2 ms |  | 🥵 |
| 46.9 ms |  | 20.2 ms | 18.6 ms |  | 🥵 |
| 318 ms | 2.4 ms | 1.8 ms | 0.2 ms | 🥶 |  |
| 11 ms |  | 2 ms | 0.2 ms |  | 🥵 |
| 13 ms |  | 1.6 ms | 0.1 ms |  | 🥵 |
| 9 ms |  | 1.7 ms | 0.1 ms |  | 🥵 |
| 20.9 ms |  | 1.7 ms | 12.6 ms |  | 🥵 |
| 9 ms |  | 1.6 ms | 0.1 ms |  | 🥵 |
| 10 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 319 ms | 2.3 ms | 2 ms | 0.1 ms | 🥶 |  |
| 9.9 ms |  | 1.7 ms | 0.2 ms |  | 🥵 |
| 31 ms |  | 21.3 ms | 0.1 ms |  | 🥵 |
| 9.9 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 8.9 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 10.9 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 9.9 ms |  | 1.7 ms | 0.2 ms |  | 🥵 |
| 319.9 ms | 2.1 ms | 2 ms | 0.2 ms | 🥶 |  |
| 36.9 ms |  | 9.9 ms | 19.1 ms |  | 🥵 |
| 56.9 ms |  | 48.3 ms | 0.3 ms |  | 🥵 |
| 309.9 ms | 2.4 ms | 1.8 ms | 0.3 ms | 🥶 |  |
| 11 ms |  | 1.8 ms | 0.2 ms |  | 🥵 |
| 12 ms |  | 1.8 ms | 0.3 ms |  | 🥵 |
| 9 ms |  | 1.8 ms | 0.3 ms |  | 🥵 |
| 9.9 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 8.9 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 359.9 ms | 2.7 ms | 2 ms | 12.8 ms | 🥶 |  |
| 9.9 ms |  | 1.6 ms | 0.2 ms |  | 🥵 |
| 8.9 ms |  | 1.9 ms | 0.2 ms |  | 🥵 |

## XRay Example of a Cold Start

<img width="1476" alt="Screenshot 2020-10-07 at 23 01 40" src="https://user-images.githubusercontent.com/1189998/95387505-178a1d00-08f1-11eb-83a7-7bc32eee48e2.png">

## XRay Example of a Warm Start

<img width="1479" alt="Screenshot 2020-10-07 at 23 01 23" src="https://user-images.githubusercontent.com/1189998/95387509-1953e080-08f1-11eb-8d46-ac25efa235e4.png">

