import { ApiWorldGetter } from "~src/Infrastructure/Api/ApiWorldGetter";
import { Http } from "~src/Infrastructure/Api/Http";
import { IConfig } from "~src/Core/Config/IConfig";
import { ProcessConfig } from "~src/Infrastructure/Config/ProcessConfig";
import { Chart } from "chart.js"
import { World } from "~src/Core/Model/World";
export class Charts {
    public constructor(private htmlElement: CanvasRenderingContext2D) {
        this.ctx = htmlElement;

        this.myChart = new Chart(this.ctx, {
            type: 'bar',
            data: {
                labels: ["Drenthe", "Flevoland", "Gelderland", "Groningen", "Noord-holland", "Limburg", "Overijssel", "Zeeland", "Zuid-holland", "Noord-brabant", "Utrecht", "Friesland"],
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


    public async setWorld(world: World) {
        world.countries.forEach(((country, countryId) => {
            country.provinces.forEach((province, provinceId) => {
                this.countsDeaths.push(province.death.statValue)
                this.countsInfected.push(province.infected.statValue)
                console.log(province.death.statValue)
            });
        }));

        this.myChart.update();
    }

    private ctx;

    private myChart: Chart
}