import { routes } from './app.routes';

describe('app routes', () => {
  it('lazy-loads profils and utilisateurs feature modules', () => {
    expect(routes.map((route) => route.path)).toEqual(['profils', 'utilisateurs']);
    expect(routes.every((route) => typeof route.loadChildren === 'function')).toBe(true);
  });
});
