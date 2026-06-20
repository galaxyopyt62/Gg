# Galaxy Stream — Web App

A single-file, no-backend streaming site. Pure HTML/CSS/JS — no build step, no server,
no database. Edit `channels.json`, open/host `index.html`, done.

## Files
- `index.html` — the entire app (UI, player engine, styling).
- `channels.json` — your channel list. This is the "database."

## Supported stream types
Set `sourceType` per channel in `channels.json`:

| sourceType | Required field        | Notes |
|------------|------------------------|-------|
| `hls`      | `streamUrl` (.m3u8)    | Played via hls.js |
| `dash`     | `streamUrl` (.mpd)     | Played via hls.js's HLS path is NOT used for DASH — see note below |
| `mp4`      | `streamUrl`            | Direct file, native `<video>` |
| `youtube`  | `embedId` (video/live ID) | Official YouTube iframe embed |
| `twitch`   | `embedId` (channel name)  | Official Twitch iframe embed |

> Note: this build wires HLS via hls.js. For true DASH support, swap in dash.js
> (`cdnjs.cloudflare.com/ajax/libs/dashjs/...`) the same way hls.js is wired in
> `attachStreamSource()` — flagged as a TODO if you need it.

## Channel JSON shape
```json
{
  "title": "Channel name",
  "subtitle": "Short description",
  "category": "Sports",
  "sourceType": "hls",
  "streamUrl": "https://yourdomain.com/stream.m3u8",
  "thumbnail": "https://yourdomain.com/thumb.jpg",
  "isLive": true
}
```

## Features included
- Hero section auto-featuring your first live channel
- Category filter chips (auto-generated from your data)
- Live search
- Full player modal (HLS/DASH/MP4 via hls.js, YouTube/Twitch via iframe)
- "Float" button — pop the current stream into a draggable-position mini player
  bottom-right while you keep browsing
- Responsive down to mobile
- No accounts, no backend, no tracking

## Hosting (pick one — all free, all work from your phone via GitHub)
**GitHub Pages** (recommended, same repo you already have):
1. Push `index.html` and `channels.json` to your repo.
2. Repo → Settings → Pages → Source: deploy from branch `main`, folder `/ (root)`.
3. Your site goes live at `https://<username>.github.io/<repo>/`.

Any other static host (Netlify, Vercel, Cloudflare Pages) works the same way —
just point it at this folder, no build command needed.

## Adding real content
Replace the sample entries in `channels.json` with:
- Your own/licensed HLS stream URLs, or
- `youtube`/`twitch` entries pointing at official, legal embeds.

No code changes needed — the app re-reads `channels.json` on every page load.
