// script.js
const boardElement = document.getElementById('chess-board');
let board;
let currentTurn = 'WHITE';

function startGame() {
    initializeBoard();
    renderBoard();
}

function initializeBoard() {
    board = new Array(8).fill(null).map(() => new Array(8).fill(null));
    // Initialize pawns
    for (let i = 0; i < 8; i++) {
        board[1][i] = { type: 'PAWN', color: 'BLACK' };
        board[6][i] = { type: 'PAWN', color: 'WHITE' };
    }
    // Initialize other pieces
    const pieces = ['ROOK', 'KNIGHT', 'BISHOP', 'QUEEN', 'KING', 'BISHOP', 'KNIGHT', 'ROOK'];
    for (let i = 0; i < 8; i++) {
        board[0][i] = { type: pieces[i], color: 'BLACK' };
        board[7][i] = { type: pieces[i], color: 'WHITE' };
    }
}

function renderBoard() {
    boardElement.innerHTML = '';
    for (let row = 0; row < 8; row++) {
        for (let col = 0; col < 8; col++) {
            const cell = document.createElement('div');
            cell.classList.add('cell');
            cell.classList.add((row + col) % 2 === 0 ? 'white' : 'black');
            if (board[row][col]) {
                cell.textContent = getPieceSymbol(board[row][col]);
                cell.setAttribute('data-row', row);
                cell.setAttribute('data-col', col);
                cell.addEventListener('click', () => selectPiece(row, col));
            }
            boardElement.appendChild(cell);
        }
    }
}

function getPieceSymbol(piece) {
    const symbols = {
        'PAWN': '♟',
        'ROOK': '♜',
        'KNIGHT': '♞',
        'BISHOP': '♝',
        'QUEEN': '♛',
        'KING': '♚'
    };
    return piece.color === 'WHITE' ? symbols[piece.type].toUpperCase() : symbols[piece.type];
}

let selectedPiece = null;

function selectPiece(row, col) {
    if (selectedPiece) {
        movePiece(selectedPiece.row, selectedPiece.col, row, col);
        selectedPiece = null;
    } else {
        selectedPiece = { row, col };
    }
}

function movePiece(startRow, startCol, endRow, endCol) {
    const piece = board[startRow][startCol];
    if (piece && piece.color === currentTurn && isValidMove(piece, startRow, startCol, endRow, endCol)) {
        board[endRow][endCol] = piece;
        board[startRow][startCol] = null;
        currentTurn = currentTurn === 'WHITE' ? 'BLACK' : 'WHITE';
        renderBoard();
    }
}

function isValidMove(piece, startRow, startCol, endRow, endCol) {
    // Implement piece-specific move validation
    const dx = Math.abs(endRow - startRow);
    const dy = Math.abs(endCol - startCol);
    switch (piece.type) {
        case 'PAWN':
            return (dx === 1 && dy === 0 && !board[endRow][endCol]) ||
                   (dx === 1 && dy === 1 && board[endRow][endCol] && board[endRow][endCol].color !== piece.color);
        case 'ROOK':
            return (dx === 0 || dy === 0);
        case 'KNIGHT':
            return (dx === 2 && dy === 1) || (dx === 1 && dy === 2);
        case 'BISHOP':
            return dx === dy;
        case 'QUEEN':
            return dx === dy || dx === 0 || dy === 0;
        case 'KING':
            return dx <= 1 && dy <= 1;
        default:
            return false;
    }
}
