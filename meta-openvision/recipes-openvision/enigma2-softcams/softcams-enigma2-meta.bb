DESCRIPTION = "meta file for enigma2 softcam packages"

require conf/license/openvision-gplv2.inc

PROVIDES = "softcams"

# softcams with source available
DEPENDS += "\
	enigma2-plugin-softcams-oscam \
	enigma2-plugin-softcams-oscam-emu \
	enigma2-plugin-softcams-oscam-smod \
	enigma2-plugin-softcams-ncam \
	"
