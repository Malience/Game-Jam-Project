#version 330 core
#include "lighting.glh"

in vec2 texCoord0;
in vec3 normal0;
in vec3 worldPos0;

uniform sampler2D diffuse;


uniform PointLight R_pointLight;

out vec4 fragColor;

void main()
{
    fragColor = texture2D(diffuse, texCoord0.xy) * calcPointLight(R_pointLight, normalize(normal0), worldPos0);
}
