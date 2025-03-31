import * as path from 'path';
import * as dotenv from 'dotenv';
import * as webpack from 'webpack';
import Dotenv from 'dotenv-webpack';

dotenv.config();

const config: webpack.Configuration = {
  entry: './src/main.ts',  // Caminho para o arquivo de entrada principal do seu projeto Angular
  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'dist'),  // Caminho onde o Webpack gerará o bundle
  },
  resolve: {
    extensions: ['.ts', '.js'],  // Adicionar suporte para TypeScript
  },
  module: {
    rules: [
      {
        test: /\.ts$/,  // Processar arquivos .ts com o ts-loader
        use: 'ts-loader',
        exclude: /node_modules/,
      },
    ],
  },
  plugins: [
    new Dotenv(),  // Usar o plugin dotenv-webpack para injetar variáveis de ambiente
    new webpack.DefinePlugin({
      'process.env.API_URL': JSON.stringify(process.env.API_URL),  // Exemplo de variável de ambiente
    }),
  ]as webpack.WebpackPluginInstance[],
};

export default config;
