declare module 'dotenv-webpack' {
    import { Plugin } from 'webpack';
  
    class DotenvWebpackPlugin extends Plugin {
      constructor(options?: any);
    }
  
    export = DotenvWebpackPlugin;
  }
  