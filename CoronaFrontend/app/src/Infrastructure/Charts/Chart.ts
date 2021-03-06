import { Chart } from "chart.js"
import { World } from "~src/Core/Model/World";
export class Charts {

    private readonly ctx;
    private myChart: Chart;

    public constructor(private htmlElement: CanvasRenderingContext2D) {
        this.ctx = htmlElement;

        this.myChart = new Chart(this.ctx, {
            type: 'bar',
            data: {
                labels: this.provinces,
                datasets: [{
                    label: 'Doden per provincie',
                    data: this.countsDeaths,
                    backgroundColor: [
                        'rgba(150, 100, 38, 0.4)',
                        'rgba(150, 100, 38, 0.4)',
                        'rgba(150, 100, 38, 0.4)',
                        'rgba(150, 100, 38, 0.4)',
                        'rgba(150, 100, 38, 0.4)',
                        'rgba(150, 100, 38, 0.4)',
                        'rgba(150, 100, 38, 0.4)',
                        'rgba(150, 100, 38, 0.4)',
                        'rgba(150, 100, 38, 0.4)',
                        'rgba(150, 100, 38, 0.4)',
                        'rgba(150, 100, 38, 0.4)',
                        'rgba(150, 100, 38, 0.4)'

                    ],
                    borderColor: [
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)'
                    ],
                    borderWidth: 1
                },
                {
                    label: 'Infecties per provincie',
                    data: this.countsInfected,
                    backgroundColor: [
                        'rgba(0, 255, 0, 0.4)',
                        'rgba(0, 255, 0, 0.4)',
                        'rgba(0, 255, 0, 0.4)',
                        'rgba(0, 255, 0, 0.4)',
                        'rgba(0, 255, 0, 0.4)',
                        'rgba(0, 255, 0, 0.4)',
                        'rgba(0, 255, 0, 0.4)',
                        'rgba(0, 255, 0, 0.4)',
                        'rgba(0, 255, 0, 0.4)',
                        'rgba(0, 255, 0, 0.4)',
                        'rgba(0, 255, 0, 0.4)',
                        'rgba(0, 255, 0, 0.4)',

                    ],
                    borderColor: [
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)',
                        'rgba(150,150,20, 1)'
                    ],
                    borderWidth: 1

                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });
    }

    private countsDeaths = new Array<number>();
    private countsInfected = new Array<number>();
    private provinces = new Array<string>();


    public setWorld(world: World) {
        world.countries.forEach(((country, countryId) => {
            country.provinces.forEach((province, provinceId) => {
                this.countsDeaths.push(province.death.statValue);
                this.countsInfected.push(province.infected.statValue);
                this.provinces.push(province.name);
            });
        }));

        this.myChart.update();
    }
}